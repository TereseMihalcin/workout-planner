package com.example.workoutapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;


public class ConfirmWorkoutAdapter extends RecyclerView.Adapter<ConfirmWorkoutHolder> {
    Context context;
    ConfirmWorkout.Exercise[] names;
    ArrayList<ConfirmWorkout.Exercise> checkedExercises;

    {
        checkedExercises = new ArrayList<>();
    }

    //nested recyclerView or something

    public ConfirmWorkoutAdapter(Context context, ConfirmWorkout.Exercise[] checkNames) {
        this.context = context;
        this.names = checkNames;

    }

    @NonNull
    @Override
    public ConfirmWorkoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.new_workout_row, parent, false);
        return new ConfirmWorkoutHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmWorkoutHolder holder, int position) {
        final ConfirmWorkout.Exercise exercise = names[position];

        // no longer using the strings in the resource file due to problems with it
        // instead access name and selection state view the class.
        holder.checkName.setText(exercise.getName());
        holder.checkBox.setChecked(exercise.isSelected());

        // setting the click listener and getting the textView names for each checkBox
        holder.setItemClickListener((v, pos) -> {
            CheckBox myCheckBox= (CheckBox) v;
            ConfirmWorkout.Exercise currentExercise = names[pos];

            // if the check box is checked then change selected to true and add the exercise to the array, else set selected to false and remove from array
            if(myCheckBox.isChecked()) {
                currentExercise.setSelected(true);
                checkedExercises.add(currentExercise);
            }
            else if(!myCheckBox.isChecked()) {
                currentExercise.setSelected(false);
                checkedExercises.remove(currentExercise);
            }

        });



        }

        @Override
    public int getItemCount() {
        // amount of items is the length of the total names
        return names.length;
    }
}
