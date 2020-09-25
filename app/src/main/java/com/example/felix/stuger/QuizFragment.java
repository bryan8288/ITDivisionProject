package com.example.felix.stuger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment extends Fragment {
    public Button btnIPA;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_quiz, container, false);

        Button btnIPS = (Button) v.findViewById(R.id.buttonIPS);
        Button btnIPA = (Button) v.findViewById(R.id.buttonIPA);
        btnIPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IPS = new Intent(getActivity(),IPSActivity.class);
                startActivity(IPS);
                getActivity().finish();

            }
        });
        btnIPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IPA = new Intent(getActivity(),IPAActivity.class);
                startActivity(IPA);
                getActivity().finish();


            }
        });

        return  v;

    }
}

