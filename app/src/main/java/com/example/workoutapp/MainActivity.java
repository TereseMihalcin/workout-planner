package com.example.workoutapp;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/*
Terese Mihalcin
Senior Capstone Project
Android Workout Planner/Educational Workout App
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get the layout
        setContentView(R.layout.activity_main);

        // new workout button and click listener
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ConfirmWorkout.class))

        );

        // get the tab layout and the view pager by id
        TabLayout tablayout = findViewById(R.id.tabs);
        ViewPager2 viewpager2 = findViewById(R.id.viewpager2);

        // set the view pager adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewpager2.setAdapter(viewPagerAdapter);

        // mediator for tablayout and viewpager2
        new TabLayoutMediator(tablayout, viewpager2, (tabs, position) -> {

            // set the text for both tabs, get them from the string resources
            tabs.setText(getResources().getStringArray(R.array.tab_text)[position]);


        }).attach();
    }

}
