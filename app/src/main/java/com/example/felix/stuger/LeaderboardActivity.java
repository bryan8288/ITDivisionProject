package com.example.felix.stuger;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.felix.stuger.Adapter.LeaderboardAdapter;
import com.example.felix.stuger.Model.Leaderboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class LeaderboardActivity extends AppCompatActivity {

    RecyclerView rvLeaderboard;
    RecyclerView.Adapter rvAdapter;
    ArrayList<Leaderboard> listLeaderboard;
    String link = "http://192.168.1.8/api/services/AchievementServices/getachievement.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        new AsyncFetch().execute();

        //listLeaderboard = new ArrayList<>();

        //testing model and adapter
//        Leaderboard Test1 = new Leaderboard();
//        Test1.setLeaderboardName("Nama1");
//        Test1.setLeaderboardTitle("Si hebat");
//        Test1.setLeaderboardScore(100);
//
//        Leaderboard Test2 = new Leaderboard();
//        Test2.setLeaderboardName("Nama2");
//        Test2.setLeaderboardTitle("Jago coding");
//        Test2.setLeaderboardScore(3000);
//
//        Leaderboard Test3 = new Leaderboard();
//        Test3.setLeaderboardName("Nama3");
//        Test3.setLeaderboardTitle("Bucin");
//        Test3.setLeaderboardScore(-10);
//
//        Leaderboard Test4 = new Leaderboard();
//        Test4.setLeaderboardName("Nama4");
//        Test4.setLeaderboardTitle("Jack of all Trades");
//        Test4.setLeaderboardScore(-1000);
//
//        listLeaderboard.add(Test1);
//        listLeaderboard.add(Test2);
//        listLeaderboard.add(Test3);
//        listLeaderboard.add(Test4);

//        rvLeaderboard = findViewById(R.id.rv_leaderboard);
//        rvLeaderboard.setLayoutManager(new LinearLayoutManager(this));
//
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvLeaderboard.getContext(), DividerItemDecoration.VERTICAL);
//        rvLeaderboard.addItemDecoration(dividerItemDecoration);
//
//        final LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(this, listLeaderboard);
//        rvLeaderboard.setAdapter(leaderboardAdapter);
        //rvAdapter = new LeaderboardAdapter(this, listLeaderboard);

        //new SendPostRequest().execute();
//        try{
//            URL url = new URL(link);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setReadTimeout(15000 /* milliseconds */);
//            conn.setConnectTimeout(15000 /* milliseconds */);
//            conn.setRequestMethod("POST");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//
//            int responseCode = conn.getResponseCode();
//
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(conn.getInputStream()));
//
//                StringBuilder builder = new StringBuilder();
//                String line = "";
//
//                while((line = in.readLine()) != null) {
//
//                    builder.append(line);
//                    break;
//                }
//
//                in.close();
//                JSONArray jsonArray = new JSONArray(builder.toString());
//                for(int i = 0; i < jsonArray.length(); i++){
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    Leaderboard leaderboard = new Leaderboard();
//                    leaderboard.setLeaderboardName(jsonObject.getString("UserName"));
//                    leaderboard.setLeaderboardTitle(jsonObject.getString("AchievementName"));
//                    leaderboard.setLeaderboardScore(jsonObject.getInt("Score"));
//
//                    listLeaderboard.add(leaderboard);
//                }
//
//                leaderboardAdapter.notifyDataSetChanged();
//            }
//            else {
//                Toast.makeText(getApplicationContext(), "false: " + responseCode, Toast.LENGTH_LONG).show();
//            }
//        }
//        catch(Exception e){
//            Toast.makeText(getApplicationContext(), "Exception: " + e.getMessage(), Toast.LENGTH_LONG).show();
//        }

    }

    private class AsyncFetch extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL(link);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            }

            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);
            } catch (ProtocolException e) {
                e.printStackTrace();
                return e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("Unsuscesful!");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        public void onPostExecute(String result) {
            ArrayList<Leaderboard> listLeaderboard = new ArrayList<>();

            try {
                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject jsonObject = jArray.getJSONObject(i);
                    Leaderboard leaderboard = new Leaderboard();
                    leaderboard.setLeaderboardName(jsonObject.getString("UserName"));
                    leaderboard.setLeaderboardTitle(jsonObject.getString("AchievementName"));
                    leaderboard.setLeaderboardScore(jsonObject.getInt("Score"));

                    listLeaderboard.add(leaderboard);
                }

                rvLeaderboard = findViewById(R.id.rv_leaderboard);
                rvLeaderboard.setLayoutManager(new LinearLayoutManager(LeaderboardActivity.this));

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvLeaderboard.getContext(), DividerItemDecoration.VERTICAL);
                rvLeaderboard.addItemDecoration(dividerItemDecoration);

                final LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(LeaderboardActivity.this, listLeaderboard);
                rvLeaderboard.setAdapter(leaderboardAdapter);

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    //use this in reference on how to use get from api
//    public class SendPostRequest extends AsyncTask<String, Void,String>{
//
//        protected void onPreExecute(){}
//
//        protected String doInBackground(String... arg0) {
//            try{
//
//                URL url = new URL(link);
//
////                JSONObject postDataParams = new JSONObject();
////                postDataParams.put("name", "abc");
////                postDataParams.put("email", "abc@gmail.com");
////                Log.e("params",postDataParams.toString());
////
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setReadTimeout(15000 /* milliseconds */);
//                conn.setConnectTimeout(15000 /* milliseconds */);
//                conn.setRequestMethod("POST");
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
////
////                OutputStream os = conn.getOutputStream();
////                BufferedWriter writer = new BufferedWriter(
////                        new OutputStreamWriter(os, "UTF-8"));
////                writer.write(getPostDataString(postDataParams));
////
////                writer.flush();
////                writer.close();
////                os.close();
//
//                int responseCode=conn.getResponseCode();
//
//                if (responseCode == HttpsURLConnection.HTTP_OK) {
//
//                    BufferedReader in = new BufferedReader(
//                            new InputStreamReader(conn.getInputStream()));
//
//                    StringBuffer sb = new StringBuffer("");
//                    StringBuilder builder = new StringBuilder();
//                    String line = "";
//
//                    while((line = in.readLine()) != null) {
//
//                        builder.append(line);
//                        break;
//                    }
//
//                    in.close();
//                    return builder.toString();
//
//                }
//                else {
//                    return new String("false : "+responseCode);
//                }
//            }
//            catch(Exception e){
//                return new String("Exception: " + e.getMessage());
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    public String getPostDataString(JSONObject params) throws Exception {
//
//        StringBuilder result = new StringBuilder();
//        boolean first = true;
//
//        Iterator<String> itr = params.keys();
//
//        while(itr.hasNext()){
//
//            String key= itr.next();
//            Object value = params.get(key);
//
//            if (first)
//                first = false;
//            else
//                result.append("&");
//
//            result.append(URLEncoder.encode(key, "UTF-8"));
//            result.append("=");
//            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
//
//        }
//        return result.toString();
//    }

}
