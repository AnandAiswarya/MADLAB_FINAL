package com.example.madlab3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<>(20);
        for(int i=0; i<20;i++)
            list.add("hello");

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new Adapter(this, 0, list));
    }

    class Adapter extends ArrayAdapter<String>
    {
        ArrayList<String> list;
        Context context;

        public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects)
        {
            super(context, resource, objects);
            this.list = objects;
            this.context = context;
        }

        @Override
        public int getCount()
        {
            return list.size();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            View v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            ((TextView)v.findViewById(android.R.id.text1)).setText(list.get(position));
            return v;
        }
    }
}