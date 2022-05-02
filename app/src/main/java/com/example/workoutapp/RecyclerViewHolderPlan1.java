package com.example.workoutapp;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// holder for the parent recycler view in the plan fragment
public class RecyclerViewHolderPlan1 extends RecyclerView.ViewHolder {

    EditText view;
    RecyclerView nestedRecycler;


    public RecyclerViewHolderPlan1(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.et_simple);
        nestedRecycler = itemView.findViewById(R.id.nestedRecycler);

    }

}
