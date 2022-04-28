package com.example.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerAdapterPlan1 extends RecyclerView.Adapter<RecyclerViewHolderPlan1> {
    String title;

    //nested recyclerView or something

    public RecyclerAdapterPlan1(String title) {
        this.title = title;

    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.full_workout_template;
    }

    @NonNull
    @Override
    public RecyclerViewHolderPlan1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderPlan1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderPlan1 holder, int position) {
        holder.view.setText(String.valueOf(title));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

}

