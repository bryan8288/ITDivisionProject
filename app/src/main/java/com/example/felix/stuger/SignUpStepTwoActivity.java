package com.example.felix.stuger;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpStepTwoActivity extends AppCompatActivity {

    TextView tvDate;
    DatePickerDialog.OnDateSetListener dateSetListener;
    String Gender = "";

    EditText etPhoneNumber;
    RadioButton rbMale, rbFemale;
    Button btnSumbit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step_two);

        etPhoneNumber = (EditText) findViewById(R.id.etSignUpPhoneNumber);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        btnSumbit = (Button) findViewById(R.id.btnSubmitSignUp);
        btnBack = (Button) findViewById(R.id.btnSignUpBack);
        tvDate = (TextView) findViewById(R.id.tvSignUpDate);

        tvDate.setText("Click here to set a date");
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PhoneNumber = etPhoneNumber.getText().toString();
                if(PhoneNumber.equals("")){
                    Toast.makeText(SignUpStepTwoActivity.this, "Phone Number can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if(Gender.equals("")){
                    Toast.makeText(SignUpStepTwoActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                }else if(tvDate.equals("Click here to set a date")){
                    Toast.makeText(SignUpStepTwoActivity.this, "Date can't be empty", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpStepOneActivity.class);
                startActivity(intent);
                finish();
            }
        });



        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(SignUpStepTwoActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                tvDate.setText(date);
            }
        };
    }



    public void onRBClick(View view){
        boolean Checked = ((RadioButton) view).isChecked();
        if(Checked){
            switch (view.getId()){
                case R.id.rbMale:
                    if (Checked){
                        Gender = "Male";
                    }
                    break;
                case R.id.rbFemale:
                    if (Checked){
                        Gender = "Female";
                    }
            }
        }
    }
}