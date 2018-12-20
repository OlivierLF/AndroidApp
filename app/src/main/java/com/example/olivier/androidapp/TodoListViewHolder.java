package com.example.olivier.androidapp;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

public class TodoListViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView content;

    private Pair<String, String> currentPair;



    public TodoListViewHolder(final View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.task_title);
        content = itemView.findViewById(R.id.task_content);

        //onClickListener to display an alert window containing the task title and the content of the task
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(itemView.getContext())
                        .setTitle(currentPair.first)
                        .setMessage(currentPair.second)
                        .show();
            }
        });
    }


    public void display(Pair<String, String> task) {
        currentPair = task;
        this.title.setText(task.first);
        this.content.setText(task.second);
    }

}

