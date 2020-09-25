package com.example.felix.stuger;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etLoginEmail, etLoginPassword;
    TextView tvSignUp;

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;

    public void checkLogin(View arg0){
        final String email = etLoginEmail.getText().toString();
        final String password = etLoginPassword.getText().toString();

        if(email.equals("admin") && password.equals("admin")){
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                finish();
        }else{
            if(isEmail(email) && password.length() > 0){
                new AsyncLogin().execute(email,password);
            }else{
                Toast.makeText(MainActivity.this, "Check your email & password again", Toast.LENGTH_SHORT).show();
            }
        }



    }

    private class AsyncLogin extends AsyncTask<String, String, String>{
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdLoading.setMessage("\tLoading");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try{
                url = new URL("localhost/api/services/UserServices/loginuser.php");
            }catch(MalformedURLException e){
                return "exception";
            }

            try{
                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", params[0])
                        .appendQueryParameter("password", params[1]);

                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();
            }catch(IOException e1) {
                return "exception";
            }

            try{
                int response_code = conn.getResponseCode();

                if(response_code == HttpURLConnection.HTTP_OK){
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while((line = reader.readLine())!= null){
                        result.append(line);
                    }

                    return(result.toString());
                }else{
                    return ("unsuccessful");
                }
            }catch(IOException e){
                return "exception";
            }finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();

            if(result.equalsIgnoreCase("true")){

                //create sharedPreference
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                finish();
            }else if (result.equalsIgnoreCase("false")){
                Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
            }else if (result.equalsIgnoreCase("exception")){
                Toast.makeText(MainActivity.this, "Oops, Something went wrong. Connection Problem ", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int PERMISSION_ALL = 1;

        String[] Permissions = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET};
        if (!hasPermissions(this, Permissions)){
            ActivityCompat.requestPermissions(this, Permissions, PERMISSION_ALL);
        }

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        etLoginEmail = (EditText)findViewById(R.id.etLoginEmail);
        etLoginPassword = (EditText)findViewById(R.id.etLoginPassword);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);

        SpannableString content = new SpannableString("Sign Up");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvSignUp.setText(content);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpStepOneActivity.class);
                startActivity(intent);
            }
        });

//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = etLoginEmail.getText().toString();
//                String password = etLoginPassword.getText().toString();
//
//                if(email.equals("admin") && password.equals("admin")){
//                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    if(isEmail(email) && password.length()>0){
//                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }else{
//                        Toast.makeText(MainActivity.this, "Check your email & password again", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
    }

    public boolean isEmail(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches() == true){
            return true;
        }else{
            return false;
        }
    }

    public static boolean hasPermissions(Context context, String... permissions){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && context!=null &&permissions!= null){
            for(String permission:permissions){
                if(ActivityCompat.checkSelfPermission(context, permission)!=PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }
}
