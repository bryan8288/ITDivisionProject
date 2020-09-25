package com.example.felix.stuger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ProfileFragment extends Fragment {

    Button btnProfile, btnAchievement;
    RelativeLayout rlProfile, rlAchievement;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false );

        btnProfile = (Button) v.findViewById(R.id.btnInnerProfile);
        btnAchievement = (Button) v.findViewById(R.id.btnInnerAchievement);
        rlProfile = (RelativeLayout) v.findViewById(R.id.rlInnerProfile);
        rlAchievement = (RelativeLayout) v.findViewById(R.id.rlInnerAchievement);

        btnAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlProfile.setVisibility(View.INVISIBLE);
                rlAchievement.setVisibility(View.VISIBLE);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlProfile.setVisibility(View.VISIBLE);
                rlAchievement.setVisibility(View.INVISIBLE);
            }
        });

        return v;


    }
}