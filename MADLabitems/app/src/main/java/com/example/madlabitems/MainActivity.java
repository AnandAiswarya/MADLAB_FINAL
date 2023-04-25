package com.example.madlabitems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza,ff,burger;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    burger=(CheckBox)findViewById(R.id.checkBox);
    pizza=(CheckBox)findViewById(R.id.checkBox2);
    ff=(CheckBox)findViewById(R.id.checkBox3);
    buttonOrder=(Button)findViewById(R.id.button);

    //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            int totalamount=0;
            StringBuilder result=new StringBuilder();
            result.append("Selected Items:");

            if(pizza.isChecked()){
                result.append("\nPizza 200Rs");

                totalamount+=200;
            }
            if(ff.isChecked()){
                result.append("\nPizza 100Rs");

                totalamount+=100;
            }
            if(burger.isChecked()){
                result.append("\nPizza 180Rs");

                totalamount+=180;
            }
            result.append("\nTotal: "+totalamount+"Rs");

            String str = result.toString();
            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
            myIntent.putExtra("message_key", str);
            startActivity(myIntent);

        }

    });
}
}