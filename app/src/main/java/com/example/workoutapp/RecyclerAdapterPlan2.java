package com.example.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// this is the child recycler view in the plan fragment
public class RecyclerAdapterPlan2 extends RecyclerView.Adapter<RecyclerViewHolderPlan2>{

    //attempting the get the array with the checked exercises into this recycler view
    // ArrayList<ConfirmWorkout.Exercise> checkedExercisesList;
    String[] checkedExercisesList;


    public RecyclerAdapterPlan2(String[] arrayList) {
        checkedExercisesList = arrayList;
    }

    @Override
    public int getItemViewType(final int position) {
        // get the layout which holds each individual checked exercise
        return R.layout.individual_workout;
    }

    @NonNull
    @Override
    public RecyclerViewHolderPlan2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolderPlan2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderPlan2 holder, int position) {

        // ConfirmWorkout.Exercise object = checkedExercisesList.get(position);
        // String text = object.getName();
        // holder.text1.setText(text);
        holder.text1.setText(String.valueOf(checkedExercisesList[position]));


    }

    @Override
    public int getItemCount() {
        return checkedExercisesList.length;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
