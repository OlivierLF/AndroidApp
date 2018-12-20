package com.example.olivier.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ButtonStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        //bind the button to the view
        ButtonStart =  findViewById(R.id.activity_main_button_start);

        //onClickListener to change activity when we click
        ButtonStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_button_start:
                Intent intent = new Intent(this, FormActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
