package com.example.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    String[] data1;
    String[] data2;

    public RecyclerViewAdapter(String[] s1, String[] s2) {
        this.data1 = s1;
        this.data2 = s2;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.my_row;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.view.setText(String.valueOf(data1[position]));
        holder.view2.setText(String.valueOf(data2[position]));
    }

    @Override
    public int getItemCount() {
        return 100;
    }

}
