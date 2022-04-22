package com.example.workoutapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tablayout = findViewById(R.id.tabs);
        ViewPager2 viewpager2 = findViewById(R.id.viewpager2);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewpager2.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tablayout, viewpager2, (tabs, position) -> {
            // seems like the tab names must be set in here
            tabs.setText("tab" + position);

            // i need a different way to do this i need to reference both fragment names that are already set ugh this is fucking awful

        }).attach();



    }

    public void launchScreen(View v) {
        // launch new activity

        Intent i = new Intent(this, newWorkout.class);
        startActivity(i);
    }
}
