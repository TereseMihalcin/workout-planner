package com.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class learnFragment extends Fragment {

    //initialize array variables
    String[] s1;
    String[] s2;

    public learnFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate the view from the xml file
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        // populate the arrays with the workouts and descriptions from the string xml file
        s1 = getResources().getStringArray(R.array.workouts);
        s2 = getResources().getStringArray(R.array.workout_description);

        // get the recycler view id
        RecyclerView recyclerView = view.findViewById(R.id.learnRecycler1);
        recyclerView.setHasFixedSize(true);

        // give it a layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //retrieve the adapter with the string arrays
        recyclerView.setAdapter(new RecyclerViewAdapter(s1, s2));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.LearnFragment);
    }
}