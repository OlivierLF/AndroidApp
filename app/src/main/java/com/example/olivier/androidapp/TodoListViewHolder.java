package com.example.olivier.androidapp;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TodoListViewHolder extends RecyclerView.ViewHolder {

    private final TextView currentTask;


    public TodoListViewHolder(final View itemView) {
        super(itemView);

        currentTask = itemView.findViewById(R.id.task);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(itemView.getContext())
                        .setMessage(currentTask.toString())
                        .show();
            }
        });
    }

    public void display(String task) {
        currentTask.setText(task);
    }
}
