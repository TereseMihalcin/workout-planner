package com.example.workoutapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// holder for the learn fragment
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView view, view2;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.textView);
        view2 = itemView.findViewById(R.id.textView2);
    }


}
