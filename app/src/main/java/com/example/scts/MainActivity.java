package com.example.scts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button angryButton = (Button) findViewById(R.id.angry_btn);
        Button angryButton2=(Button) findViewById(R.id.angry_btn1);
        angryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        angryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// Click event trigger here
            }
        });
    }

}