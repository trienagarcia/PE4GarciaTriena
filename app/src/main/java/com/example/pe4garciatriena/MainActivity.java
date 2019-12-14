package com.example.pe4garciatriena;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText country, gold, silver, bronze;
    DBhelper helper;
    Cursor cursor;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBhelper(this);
        cursor = helper.getTable();
        country = findViewById(R.id.editText);
        gold = findViewById(R.id.editText2);
        silver = findViewById(R.id.editText3);
        bronze = findViewById(R.id.editText4);

        //final ArrayList array_list = helper.getAllCotacts();
        //listview = findViewById(R.id.list);
        //final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                //android.R.layout.simple_list_item_1, array_list);
        //listview.setAdapter(arrayAdapter);
       // ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.ListView,R.id.list,StringArray);
    }
    public void addRecord (View view) {
        String bCountry = country.getText().toString();
        String bGold = gold.getText().toString();
        String bSilver = silver.getText().toString();
        String bBronze = bronze.getText().toString();
        long isInserted = helper.insert(bCountry, bGold, bSilver, bBronze);
        if(isInserted == -1){
            Toast.makeText(this, "not inserted", Toast.LENGTH_LONG);
        }else{
            Toast.makeText(this, "record inserted", Toast.LENGTH_LONG);
        }
    }
    public void removeRecord(View v){
        String aCountry = country.getText().toString();
        int numDeleted = helper.delete(aCountry);
        if(numDeleted == 1){
            Toast.makeText(this, "record removed...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "deletion failed...", Toast.LENGTH_LONG).show();
        }
    }
    public void editRecord(View v){
        String bCountry = country.getText().toString();
        String bGold = gold.getText().toString();
        String bSilver = silver.getText().toString();
        String bBronze = bronze.getText().toString();
        helper.update(bCountry, bGold, bSilver, bBronze);
        int numUpdated = helper.update(bCountry, bGold, bSilver, bBronze);
        if(numUpdated == 1){
            Toast.makeText(this, "record updated...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "update failed...", Toast.LENGTH_LONG).show();
        }

    }
    public void clear(View v) {
        country.getText().clear();
        gold.getText().clear();
        silver.getText().clear();
        bronze.getText().clear();
    }

}
