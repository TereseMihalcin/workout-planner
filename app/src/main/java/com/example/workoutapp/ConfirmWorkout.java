package com.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ConfirmWorkout extends AppCompatActivity {

    RecyclerView recyclerViewAdd;
    boolean checkBox;


    // Exercise class just holding the exercise name
    public class Exercise {
        public String checkName;



        public Exercise(String checkName) {
            this.checkName = checkName;

        }

        public boolean isSelected() {
            return checkBox;
        }

        public String getName() {
            return checkName;
        }

        public void setName(String name) {
            this.checkName = name;
        }

        public void setSelected(boolean selected) {
            checkBox = selected;
        }

    }



    // the back button in the menu
    // not showing up now for some reason?:(
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }



    // list of exercises
    public Exercise[] getWorkouts() {
        final Exercise[] exercises = { new Exercise("push-up"),
                new Exercise("pull-up"),
                new Exercise("Bench Press"),
                new Exercise("Overhead Press"),
                new Exercise("Exercise"),
                new Exercise("Exercise"),
                new Exercise("Exercise"),
                new Exercise("Exercise"),
                new Exercise("Exercise"),
                new Exercise("Exercise"),
                new Exercise("Exercise")

        };
        return exercises;
    }

    //  string builder
    StringBuilder sb = null;
    ConfirmWorkoutAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_workout);



        adapter= new ConfirmWorkoutAdapter(this,getWorkouts());

        // recycler view code
        recyclerViewAdd = findViewById(R.id.recyclerView);
        recyclerViewAdd.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdd.setAdapter(adapter);


        //Not really sure how to properly set the ArrayList of all checked exercises
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            sb = new StringBuilder();
            int i = 0;
            do {
                Exercise exercise = adapter.checkedExercises.get(i);
                sb.append(exercise.getName());

                if(i != adapter.checkedExercises.size()-1){
                    sb.append(" ");
                }
                i++;

            } while
            (i < adapter.checkedExercises.size());

            if(adapter.checkedExercises.size()>0)
            {


                //this is where I need to send the array data to the other screen
                Toast.makeText(ConfirmWorkout.this,sb.toString(),Toast.LENGTH_SHORT).show();
            }else {
                //this actually doesnt work! so if you dont check any boxes and click the plus button then the activity will crash
                Toast.makeText(ConfirmWorkout.this, "Please Check An Item First or hit the back button", Toast.LENGTH_SHORT).show();
            }

        });

    }

}

