package com.example.olivier.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button submitTaskButton;
    Button seeListButton;
    EditText taskTitle;
    EditText taskContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initView();
    }

    private void initView() {
        //bind variables to the view
        submitTaskButton =  findViewById(R.id.activity_form_button_submit);
        seeListButton = findViewById(R.id.activity_form_see_list_button);
        taskTitle =  findViewById(R.id.activity_form_text_field_title);
        taskContent =  findViewById(R.id.activity_form_text_field_content);

        //onClickListeneer on the 'add task' button in order to add the task to the list and to start the ListActivity when we click on the button
        submitTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveTask();
                Intent intent = new Intent(FormActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        //start the ListActivity onClick
        seeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveTask() {
        //initialize the pair that will be added getting the text from the inputs
        Pair<String, String> newTaskTitle = new Pair (taskTitle.getText().toString(), taskContent.getText().toString());
        if (!newTaskTitle.first.isEmpty()){ //check if there is a title for the new task
            //add the task to the list contained in the dataManager
            DataManager.getInstance().addTask(newTaskTitle);
        } else {
            //suggest to enter some text when the title is empty
            Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show();
        }
    }
}
