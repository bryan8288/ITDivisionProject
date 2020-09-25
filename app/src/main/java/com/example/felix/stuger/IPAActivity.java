package com.example.felix.stuger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class IPAActivity extends AppCompatActivity {
private Button Homebtn;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipa);

        Homebtn = findViewById(R.id.ButtonHome);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner9);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IPAActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Biologi));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(i == 1){
                    startActivity (new Intent(IPAActivity.this,Bab1Bio.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(i == 2){
                    startActivity (new Intent(IPAActivity.this,Bab2Bio.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(i == 3){
                    startActivity (new Intent( IPAActivity.this,Bab3Bio.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner = (Spinner) findViewById(R.id.spinner6);
        myAdapter = new ArrayAdapter<String>(IPAActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Fisika));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int j, long id) {
                if(j == 1){
                    startActivity (new Intent(IPAActivity.this,Bab1Fis.class));
                    String text = parent.getItemAtPosition(j).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(j == 2){
                    startActivity (new Intent(IPAActivity.this,Bab2Fis.class));
                    String text = parent.getItemAtPosition(j).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(j == 3){
                    startActivity (new Intent( IPAActivity.this,Bab3Fis.class));
                    String text = parent.getItemAtPosition(j).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner = (Spinner) findViewById(R.id.spinner7);
        myAdapter = new ArrayAdapter<String>(IPAActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Kimia));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int k, long id) {
                if(k == 1){
                    startActivity (new Intent(IPAActivity.this,Bab1Kim.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(k == 2){
                    startActivity (new Intent(IPAActivity.this,Bab2Kim.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(k == 3){
                    startActivity (new Intent( IPAActivity.this,Bab3Kim.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner = (Spinner) findViewById(R.id.spinner8);
        myAdapter = new ArrayAdapter<String>(IPAActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Matematika));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int l, long id) {
                if(l == 1){
                    startActivity (new Intent(IPAActivity.this,Bab1Math.class));
                    String text = parent.getItemAtPosition(l).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(l == 2){
                    startActivity (new Intent(IPAActivity.this,Bab2Math.class));
                    String text = parent.getItemAtPosition(l).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(l == 3){
                    startActivity (new Intent( IPAActivity.this,Bab3Math.class));
                    String text = parent.getItemAtPosition(l).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void openDashboardActivity() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
