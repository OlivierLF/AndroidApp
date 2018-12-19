package com.example.olivier.androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {

    Button goBackButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
    }

    private void initView() {
        goBackButton =  findViewById(R.id.activity_list_back_button);
        final RecyclerView rv = findViewById(R.id.activity_list_todo_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new TodoListAdapter());

        goBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }


}
