package com.example.olivier.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        submitTaskButton =  findViewById(R.id.activity_form_button_submit);
        seeListButton = findViewById(R.id.activity_form_see_list_button);
        taskTitle =  findViewById(R.id.activity_form_text_field_title);
        taskContent =  findViewById(R.id.activity_form_text_field_content);

        submitTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveTask();
                Intent intent = new Intent(FormActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        seeListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveTask() {
        Pair<String, String> newTaskTitle = new Pair (taskTitle.getText().toString(), taskContent.getText().toString());
        if (!newTaskTitle.first.isEmpty()){
            DataManager.getInstance().addTask(newTaskTitle);
        } else {
            Toast.makeText(this, "Enter text", Toast.LENGTH_SHORT).show();
        }
    }


    /*
    // this was made to transfer data from one activity to another using the common instance
    private void saveData() {
        String name = submitTextField.getText().toString();

        if (!name.isEmpty()){
            DataManager.getInstance().setTextDisplay(name);
        } else {
            Toast.makeText(this, "Veuillez saisir votre nom", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
    */
}
