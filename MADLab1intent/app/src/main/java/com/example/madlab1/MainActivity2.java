package com.example.madlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView name = findViewById(R.id.putname);
        Intent myIntent = getIntent();
        String str = myIntent.getStringExtra("message_key");
        name.setText("Thank you for registering "+str);
    }
}