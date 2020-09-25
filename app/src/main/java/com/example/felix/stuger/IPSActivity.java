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

public class IPSActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_ips);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);

        Homebtn = findViewById(R.id.ButtonHome);
        Homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboardActivity();
            }
        });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IPSActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Ekonomi));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if(i == 1){
                    startActivity (new Intent(IPSActivity.this,Bab1Eko.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(i == 2){
                    startActivity (new Intent(IPSActivity.this,Bab2Eko.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(i == 3){
                    startActivity (new Intent( IPSActivity.this,Bab3Eko.class));
                    String text = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner = (Spinner) findViewById(R.id.spinner3);
        myAdapter = new ArrayAdapter<String>(IPSActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Geografi));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int u, long id) {
                if(u == 1){
                    startActivity (new Intent(IPSActivity.this,Bab1Geo.class));
                    String text = parent.getItemAtPosition(u).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(u == 2){
                    startActivity (new Intent(IPSActivity.this,Bab2Geo.class));
                    String text = parent.getItemAtPosition(u).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(u == 3){
                    startActivity (new Intent( IPSActivity.this,Bab3Geo.class));
                    String text = parent.getItemAtPosition(u).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner =(Spinner) findViewById(R.id.spinner4);
        myAdapter = new ArrayAdapter<String>(IPSActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.PPKN));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int k, long id) {
                if(k == 1){
                    startActivity (new Intent(IPSActivity.this,Bab1Ppkn.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(k == 2){
                    startActivity (new Intent(IPSActivity.this,Bab2Ppkn.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(k == 3){
                    startActivity (new Intent( IPSActivity.this,Bab3Ppkn.class));
                    String text = parent.getItemAtPosition(k).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mySpinner =(Spinner) findViewById(R.id.spinner5);
        myAdapter = new ArrayAdapter<String>(IPSActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Sosiologi));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int l, long id) {
                if(l == 1){
                    startActivity (new Intent(IPSActivity.this,Bab1Sos.class));
                    String text = parent.getItemAtPosition(l).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(l == 2){
                    startActivity (new Intent(IPSActivity.this,Bab2Sos.class));
                    String text = parent.getItemAtPosition(l).toString();
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
                else if(l == 3){
                    startActivity (new Intent( IPSActivity.this,Bab3Sos.class));
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
