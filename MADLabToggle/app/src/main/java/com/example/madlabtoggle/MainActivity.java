package com.example.madlabtoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button button;
    ToggleButton toggleButton;
    LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        toggleButton = findViewById(R.id.toggleButton);
        parent = findViewById(R.id.parent);

        final Toast toast = new Toast(this);
        final View view = LayoutInflater.from(this).inflate(R.layout.toast_view, parent, false);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);

        toggleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toggleButton.isChecked())
                {
                    ((ImageView)view.findViewById(R.id.toast_img)).setImageResource(R.drawable.sil);
                    ((TextView)view.findViewById(R.id.toast_txt)).setText("Silent mode");
                    toast.show();
                }
                else
                {
                    ((ImageView)view.findViewById(R.id.toast_img)).setImageResource(R.drawable.phn);
                    ((TextView)view.findViewById(R.id.toast_txt)).setText("Normal mode");
                    toast.show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(toggleButton.isChecked())
                {
                    ((AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE)).setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    Toast.makeText(MainActivity.this, "Silent mode is now on", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ((AudioManager) getBaseContext().getSystemService(Context.AUDIO_SERVICE)).setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    Toast.makeText(MainActivity.this, "SIlent mode is now off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}