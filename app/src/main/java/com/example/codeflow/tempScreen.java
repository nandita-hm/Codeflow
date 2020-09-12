package com.example.codeflow;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tempScreen extends AppCompatActivity {
    static String username;
    TextView textView;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_screen);
        userId = getIntent().getStringExtra("USER_ID");
        textView=findViewById(R.id.name);
        textView.setText("Hello "+userId);


    }
}