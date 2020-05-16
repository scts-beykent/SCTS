package com.example.scts_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginDemoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);

        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Giriş Yap");
        toolbar.setNavigationIcon(R.drawable.ic_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LoginDemoActivity.this, MainActivity.class);
                //startActivity(intent);
                //finish();
                onBackPressed();
            }
        });

        //setSupportActionBar(toolbar);
    }
}
