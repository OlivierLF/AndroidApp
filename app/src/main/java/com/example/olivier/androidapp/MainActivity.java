package com.example.olivier.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TextViewName;
    //TextView TestTextView;
    Button ButtonPrint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        TextViewName = findViewById(R.id.activity_main_textView_name);
        //TestTextView = findViewById((R.id.activity_main_test_text));
        ButtonPrint =  findViewById(R.id.activity_main_button_print);

        ButtonPrint.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_button_print:
                Intent intent = new Intent(this, FormActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        String newField = DataManager.getInstance().getTextDisplay();
        //TestTextView.setText(newField);
    }
}
