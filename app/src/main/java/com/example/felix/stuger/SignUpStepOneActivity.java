package com.example.felix.stuger;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpStepOneActivity extends AppCompatActivity {

    ImageView ivProfile;
    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnNext, btnBack, btnAddPicture;

    Integer REQUEST_CAMERA = 1, SELECT_FILE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step_one);

        etName = (EditText) findViewById(R.id.etSignUpName);
        etEmail = (EditText) findViewById(R.id.etSignUpEmail);
        etPassword = (EditText) findViewById(R.id.etSignUpPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnBack = (Button) findViewById(R.id.btnSignUpBack);
        btnAddPicture = (Button) findViewById(R.id.btnSignUpAddPicture);
        ivProfile = (ImageView) findViewById(R.id.ivSignUpProfile);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (name.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(SignUpStepOneActivity.this, "Fill all the column", Toast.LENGTH_SHORT).show();
                } else if (!isEmail(email)) {
                    Toast.makeText(SignUpStepOneActivity.this, "Email format is wrong", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6 || password.length() > 20) {
                    Toast.makeText(SignUpStepOneActivity.this, "Password length 6-20 char", Toast.LENGTH_SHORT).show();
                } else if (!isSamePassword(password, confirmPassword)) {
                    Toast.makeText(SignUpStepOneActivity.this, "Password is not same", Toast.LENGTH_SHORT).show();
                }else {
                    //simpen data ke DB atau kirim data ke SignUpStepTwo dulu baru disimpen
                    Intent intent = new Intent(getApplicationContext(), SignUpStepTwoActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAddPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAction();
            }
        });

    }

    public void setAction(){
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpStepOneActivity.this);
        builder.setTitle("Add Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(items[i].equals("Camera")){

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if(intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, REQUEST_CAMERA);
                    }

                }else if(items[i].equals("Gallery")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);
                }else if(items[i].equals("Cancel")){
                    dialogInterface.dismiss();
                }
            }
        });

        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){
            if(requestCode == REQUEST_CAMERA){

                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                ivProfile.setImageBitmap(bmp);

            }else if(requestCode == SELECT_FILE){

                Uri selectedImageUri = data.getData();
                ivProfile.setImageURI(selectedImageUri);

            }
        }
    }

    public boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true) {
            return true;
        }
        return false;
    }

    public boolean isSamePassword(String password, String confirmPassword){
        if (confirmPassword.equals(password)) {
            return true;
        }
        return false;
    }
}