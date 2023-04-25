package com.example.madlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next =findViewById(R.id.button);



        EditText text = findViewById(R.id.Name);
        next.setOnClickListener(
                new View.OnClickListener() {
            public void onClick(View view) {
                String str = text.getText().toString();
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("message_key", str);
                startActivity(myIntent);

            }
        });

    }
}