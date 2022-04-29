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
import android.widget.TextView;


public class planFragment extends Fragment {

    String title;

    public planFragment () {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // String data = getArguments().getString("message");
        View view =  inflater.inflate(R.layout.fragment_plan, container, false);






        //string from resource file
        title = getResources().getString(R.string.workout_title);

        RecyclerView recyclerView = view.findViewById(R.id.planRecycler1);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RecyclerAdapterPlan1(title));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.PlanFragment);
    }
}