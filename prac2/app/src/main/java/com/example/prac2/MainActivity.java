package com.example.prac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Menu actionBarMenu;
    private int selectedItemPosition = -1;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItemPosition = position;
                startActionMode(actionModeCallback);
                return true;
            }
        });
    }

    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.action_menu, menu);
            actionBarMenu = menu;
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    deleteSelectedItem();
                    mode.finish();
                    // Handle delete action for the selected item
                    return true;
                case R.id.action_share:
                    gotonextpage();
                    mode.finish();
                    // Handle share action for the selected item
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionBarMenu = null;
        }
    };
    private void deleteSelectedItem() {
        if (selectedItemPosition >= 0 && selectedItemPosition < items.size()) {
            items.remove(selectedItemPosition);
            adapter.notifyDataSetChanged();
        }
    }
    private void gotonextpage() {
        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarMenu != null && selectedItemPosition >= 0 && selectedItemPosition < listView.getCount()) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    deleteSelectedItem();
                    // Handle delete action for the selected item
                    return true;
                case R.id.action_share:
                    gotonextpage();
                    // Handle share action for the selected item
                    return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}



