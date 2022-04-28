package com.example.workoutapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolderPlan1 extends RecyclerView.ViewHolder {

    TextView view;


    public RecyclerViewHolderPlan1(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.WorkoutTitle);
    }
}
