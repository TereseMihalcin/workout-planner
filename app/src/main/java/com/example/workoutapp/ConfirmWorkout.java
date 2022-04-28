package com.example.workoutapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ConfirmWorkout extends AppCompatActivity {
    RecyclerView recyclerViewAdd;

    String checkName;
    boolean checkBox;

    public class Exercise {
        // private boolean checkBox;
        private String checkName;

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


    private Exercise[] getWorkouts() {
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

        // back button set this up a different way (low priority)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // get the values for the array


        //checkName = getResources().getStringArray(R.array.workouts);


        adapter= new ConfirmWorkoutAdapter(this,getWorkouts());

        // recycler view code
        recyclerViewAdd = findViewById(R.id.recyclerView);
        recyclerViewAdd.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdd.setAdapter(adapter);

        //addListenerOnButtonClick();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            sb = new StringBuilder();
            int i = 0;
            do {
                Exercise exercise=adapter.checkedExercises.get(i);
                sb.append(exercise.getName());
                if(i != adapter.checkedExercises.size()-1){
                    sb.append("n");
                }
                i++;

            }while (i < adapter.checkedExercises.size());

            if(adapter.checkedExercises.size()>0)
            {
                Toast.makeText(ConfirmWorkout.this,sb.toString(),Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(ConfirmWorkout.this, "Please Check An Item First or hit the back button", Toast.LENGTH_SHORT).show();
            }

        });
    }
}



    /*
    private void addListenerOnButtonClick() {
        yesCheck = (CheckBox) findViewById(R.id.checkBox2);

        yesCheck.setOnClickListener((View.OnClickListener) view -> {
            StringBuilder result=new StringBuilder();
            result.append("Selected Items:");
            if(yesCheck.isChecked()){
                result.append(" something was checked");

            }

            result.append("\nTotal");
            //Displaying the message on the toast
            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            // add the checkbox string value to an array
            //then you can populate the array in another view
        });
    }
*/

