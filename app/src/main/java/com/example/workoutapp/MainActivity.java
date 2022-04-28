package com.example.workoutapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get the layout
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
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
            // seems like the tab names must be set in here
            tabs.setText("tab" + position);

            // i need a different way to do this

        }).attach();



    }





}
