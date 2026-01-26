package com.example.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IntroSceneFragment extends Fragment {

    private TextView dialogueText;
    private TextView speakerName;
    private int currentStep = 0;

    public IntroSceneFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_scene, container, false);
        
        ImageView dogImage = view.findViewById(R.id.dogImage);
        ImageView catImage = view.findViewById(R.id.catImage);
        dialogueText = view.findViewById(R.id.dialogueText);
        speakerName = view.findViewById(R.id.speakerName);
        View tapToContinue = view.findViewById(R.id.tapToContinue);

        dogImage.setImageResource(R.drawable.pet_dog);
        catImage.setImageResource(R.drawable.pet_cat);

        view.setOnClickListener(v -> {
            advanceDialogue();
        });

        return view;
    }

    private void advanceDialogue() {
        if (currentStep == 0) {
            playTapSfx();
            dialogueText.setText("\"THERE'S NO RUSH, JUST STAY WITH US.\"");
            speakerName.setText("-LUMA");
            speakerName.setTextColor(0xFF90EE90); // Green color for Luma
            currentStep++;
        } else {
            // Handle further steps or end of scene
        }
    }

    private void playTapSfx() {
        if (getContext() != null) {
            MediaPlayer sfxPlayer = MediaPlayer.create(getContext(), R.raw.sfx_tap_to_start);
            if (sfxPlayer != null) {
                sfxPlayer.setVolume(0.05f, 0.05f);
                sfxPlayer.setOnCompletionListener(MediaPlayer::release);
                sfxPlayer.start();
            }
        }
    }
}
