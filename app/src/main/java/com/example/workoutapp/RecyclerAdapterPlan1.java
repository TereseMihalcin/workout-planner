package com.example.workoutapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class RecyclerAdapterPlan1 extends RecyclerView.Adapter<RecyclerViewHolderPlan1> {
    String title;
    // ArrayList<ConfirmWorkout.Exercise> checkedExercises;
    String[] checkedExercises;
    Activity activity;

    //nested recyclerView or something

    public RecyclerAdapterPlan1(Activity activity, String[] checkedExercises, String workoutTitle) {
        this.checkedExercises = checkedExercises;
        this.activity = activity;
        this.title = workoutTitle;

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
        // bind the textview in th holder to the value of title variable
        holder.view.setText(String.valueOf(title));

        // this is the nested recycler view code binding the array values to the recycler
        // this is code for if I figure out the ArrayList
        RecyclerAdapterPlan2 recycler2 = new RecyclerAdapterPlan2(checkedExercises);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.nestedRecycler.setLayoutManager(linearLayoutManager);
        holder.nestedRecycler.setAdapter(recycler2);

    }


    // get the overall amount of items in the recycler
    @Override
    public int getItemCount() {
        return 3;
    }

}

