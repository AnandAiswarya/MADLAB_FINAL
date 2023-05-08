package com.example.prac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox idli,dosa,idi;
    Button buttonsub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        ListView listView = findViewById(R.id.list);
        ArrayList<String> list = new ArrayList<>(5);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        list.add("Selected foods: ");
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        idli=(CheckBox)findViewById(R.id.checkBox);
        dosa=(CheckBox)findViewById(R.id.checkBox2);
        idi=(CheckBox)findViewById(R.id.checkBox3);
        buttonsub=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonsub.setOnClickListener(view -> {
            StringBuilder result=new StringBuilder();


            result.append("Selected Items:");
            if(idli.isChecked()){
                list.add("Idli");
                adapter.notifyDataSetChanged();
                result.append("\nIdli");

            }
            if(dosa.isChecked()){
                list.add("Dosa");
                adapter.notifyDataSetChanged();
                result.append("\nDosa");

            }
            if(idi.isChecked()){
                list.add("Idiyappam");
                adapter.notifyDataSetChanged();
                result.append("\nIdi");

            }
            String str = result.toString();
            System. out. println(str);
            Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
            myIntent.putExtra("message_key", str);
            startActivity(myIntent);

        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.prac_menu, menu);
        return true;}
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {case R.id.new_game:
            newGame();
            return true;
            case R.id.help:
                showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);}}

    private void showHelp() {
        Toast.makeText(getApplicationContext(),"New game", Toast.LENGTH_SHORT).show();
    }

    private void newGame() {
        Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_SHORT).show();
    }

}