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



    public class ExerciseName {

        public String editText;

        public ExerciseName(String editText) {
            this.editText = editText;
        }


    }





    public class Exercise {
        // private boolean checkBox;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }


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

    StringBuilder sb = null;
    ConfirmWorkoutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_workout);

        // get id for the edit text field


        //checkName = getResources().getStringArray(R.array.workouts);


        adapter= new ConfirmWorkoutAdapter(this,getWorkouts());

        // recycler view code
        recyclerViewAdd = findViewById(R.id.recyclerView);
        recyclerViewAdd.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdd.setAdapter(adapter);

        // addListenerOnButtonClick();

        ArrayList<Exercise> checkedList = adapter.checkedExercises;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            sb = new StringBuilder();
            int i = 0;
            do {
                Exercise exercise=adapter.checkedExercises.get(i);
                sb.append(exercise.getName());
                if(i != adapter.checkedExercises.size()-1){
                    sb.append(" ");
                }
                i++;

            }while (i < adapter.checkedExercises.size());

            if(adapter.checkedExercises.size()>0)
            {
                //this is where i need to send the array data to the other screen
                Toast.makeText(ConfirmWorkout.this,sb.toString(),Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(ConfirmWorkout.this, "Please Check An Item First or hit the back button", Toast.LENGTH_SHORT).show();
            }

            // changes the value in edit text into a string value
            EditText editText = (EditText) findViewById(R.id.et_simple);
            String strValue = editText.getText().toString();

            // attempt to send data to planFragment
            Bundle bundle = new Bundle();
            bundle.putString("message", strValue );
            planFragment fragInfo = new planFragment();
            fragInfo.setArguments(bundle);

        });

    }

}

