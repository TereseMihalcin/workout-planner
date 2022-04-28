package com.example.workoutapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConfirmWorkoutHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView checkName;
    CheckBox checkBox;
    ItemClickListener itemClickListener;

    public ConfirmWorkoutHolder(@NonNull View itemView) {
        super(itemView);
        checkName = itemView.findViewById(R.id.textView4);
        checkBox = itemView.findViewById(R.id.checkBox2);

        checkBox.setOnClickListener(this);
    }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }
        interface ItemClickListener {

            void onItemClick(View v,int pos);
        }
}


