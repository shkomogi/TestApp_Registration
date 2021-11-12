package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        //Adapter, Listener, onCreate=toast in a switch
        EditText userName;
        EditText userEmail;
        EditText userDescription;

        //1. Instances + onCLick listeners for buttons
        Spinner spinnerCountry = (Spinner) findViewById(R.id.countrySpinner);

        Button radioButtonM = (Button) findViewById(R.id.maleGender);
        //radioButtonM.setOnClickListener((View.OnClickListener) this);
        radioButtonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Male Selected", Toast.LENGTH_LONG).show();
            }
        });

        Button radioButtonF = (Button) findViewById(R.id.femaleGender);
        radioButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Female Selected", Toast.LENGTH_LONG).show();
            }
        });
        //radioButtonF.setOnClickListener((View.OnClickListener) this);
        Button radioButtonO=  (Button) findViewById(R.id.otherGender);
        radioButtonO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Other Selected", Toast.LENGTH_LONG).show();
            }
        });
        //radioButtonO.setOnClickListener((View.OnClickListener) this);
        Button radioButtonFinish = (Button) findViewById(R.id.finishButton);
        radioButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finish Button CLicked", Toast.LENGTH_LONG).show();
            }
        });
        //radioButtonFinish.setOnClickListener((View.OnClickListener) this);

        //2. APplying Listener + new Adapter -

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Country selected",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this,"No Selection",Toast.LENGTH_LONG).show();

            }
        });

//3. Creating Adapter to connect/link
//create adapter to link Spinner in xml
        /**ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,R.id.countrySpinner);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerCountry.setAdapter(aa);**/

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,R.id.countrySpinner);

        spinnerCountry.setAdapter(spinnerAdapter);


//// Implement the OnClickListener callback




    }
    //Let's create an onOptionsItemSelected for Radio buttons




//overrides default onCreate method
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        inflater.inflate(R.menu.bottommenu,menu);
        return true;


    }

//adds a toast to the menu items declared in main_menu xml
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backArrow:
                //show toast
                Toast.makeText(MainActivity.this, "Back to Previous", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this, "Settings selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.mic:
                //show toast
                Toast.makeText(MainActivity.this, "Mic selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.cart:
                Toast.makeText(MainActivity.this, "Cart selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.timer:
                Toast.makeText(MainActivity.this, "Timer selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //set on click listener for Radio Button
}