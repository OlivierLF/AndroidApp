package com.example.olivier.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button submitButton;
    EditText submitTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initView();
    }

    private void initView() {
        submitButton =  findViewById(R.id.activity_form_button_submit);
        submitTextField =  findViewById(R.id.activity_form_text_field);
        final RecyclerView rv = findViewById(R.id.activity_form_todo_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new TodoListAdapter());

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveTask();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    private void saveTask() {
        String newTask = submitTextField.getText().toString();
        if (!newTask.isEmpty()){
            DataManager.getInstance().addTask(newTask);
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
