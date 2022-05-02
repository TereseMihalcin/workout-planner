package com.example.workoutapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// holder for the child recycler in plan fragment
public class RecyclerViewHolderPlan2 extends RecyclerView.ViewHolder{
    TextView text1;

    public RecyclerViewHolderPlan2(@NonNull View itemView) {
        super(itemView);
        text1 = itemView.findViewById(R.id.exerciseTitle);
    }
}
