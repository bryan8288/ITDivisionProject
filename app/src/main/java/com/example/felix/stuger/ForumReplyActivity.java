package com.example.felix.stuger;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felix.stuger.Adapter.ForumReplyAdapter;
import com.example.felix.stuger.Model.ForumReply;

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
import java.util.ArrayList;

public class ForumReplyActivity extends AppCompatActivity {

    RecyclerView rvForumReply;
    ArrayList<ForumReply> listForumReply;
    String linkGet = "http://192.168.1.8/api/services/ForumReplyServices/getforumreply.php";
    String linkPost = "http://192.168.1.8/api/services/ForumReplyServices/newforumreply.php";

    TextView tvQuestionName, tvQuestionDesc;
    EditText etSubmitAnswer;
    Button btnSubmitAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_reply);

        Intent intent = this.getIntent();

        String name = intent.getExtras().getString("name");
        String desc = intent.getExtras().getString("desc");
        final String forumid = intent.getExtras().getString("forumid");

        tvQuestionName = findViewById(R.id.tv_question_name);
        tvQuestionDesc = findViewById(R.id.tv_question_description);
        etSubmitAnswer = findViewById(R.id.et_submit_answer);
        btnSubmitAnswer = findViewById(R.id.btn_submit_answer);

        tvQuestionName.setText(name);
        tvQuestionDesc.setText(desc);

        listForumReply = new ArrayList<>();

        rvForumReply = findViewById(R.id.rv_forum_reply);
        rvForumReply.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvForumReply.getContext(), DividerItemDecoration.VERTICAL);
        rvForumReply.addItemDecoration(dividerItemDecoration);

        final ForumReplyAdapter forumReplyAdapter = new ForumReplyAdapter(this, listForumReply);
        rvForumReply.setAdapter(forumReplyAdapter);

        new AsyncPost(rvForumReply, forumid).execute();

        if(intent.getExtras().getString("answer") != null){
            String answer = intent.getExtras().getString("answer");

            //adding answer from forum general
//            ForumReply NewAnswer = new ForumReply();
//            NewAnswer.setForumReplyName("Penjawab 1");
//            NewAnswer.setForumReplyDesc(answer);
//            NewAnswer.setForumScore(0);
//
//            listForumReply.add(NewAnswer);
//            forumReplyAdapter.notifyDataSetChanged();

            new AsyncNewReply(rvForumReply, "Penjawab", answer, forumid);
            forumReplyAdapter.notifyDataSetChanged();
        }

        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etSubmitAnswer.getText().toString();

                if(answer.length() < 20){
                    Toast.makeText(getApplicationContext(), "Jawaban minimal memiliki 20 karakter!", Toast.LENGTH_SHORT).show();
                }
                else{
//                    ForumReply NewAnswer = new ForumReply();
//                    NewAnswer.setForumReplyName("Penjawab 1");
//                    NewAnswer.setForumReplyDesc(answer);
//                    NewAnswer.setForumScore(0);
//
//                    listForumReply.add(NewAnswer);
//                    forumReplyAdapter.notifyDataSetChanged();
                    new AsyncNewReply(rvForumReply, "Penjawab", answer, forumid);
                    forumReplyAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private class AsyncPost extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL url = null;

        RecyclerView rvForumReply;
        String forumid;

        public AsyncPost(RecyclerView rvForumReply, String forumid){
            this.rvForumReply = rvForumReply;
            this.forumid = forumid;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                url = new URL(linkGet);
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

                //setDoInput to true as we send data using json file
                conn.setDoInput(true);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ForumID", forumid);
                String message = jsonObject.toString();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(message);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (ProtocolException e) {
                e.printStackTrace();
                return e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } catch (JSONException e) {
                e.printStackTrace();
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

                    return ("Unsuccessful!");
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
            ArrayList<ForumReply> listForumReply = new ArrayList<>();

            try {
                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject jsonObject = jArray.getJSONObject(i);
                    ForumReply forumReply = new ForumReply();
                    forumReply.setForumReplyID(jsonObject.getString("ForumReplyID"));
                    forumReply.setForumReplyName(jsonObject.getString("ReplyMaker"));
                    forumReply.setForumReplyDesc(jsonObject.getString("ForumReplyDescription"));
                    forumReply.setForumScore(jsonObject.getInt("ForumScore"));

                    listForumReply.add(forumReply);
                }

                final ForumReplyAdapter forumReplyAdapter = new ForumReplyAdapter(getApplicationContext(), listForumReply);
                rvForumReply.setAdapter(forumReplyAdapter);

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private class AsyncNewReply extends AsyncTask<String, String, String>{
        HttpURLConnection conn;
        URL url = null;

        RecyclerView rvForumReply;
        String replymaker, forumreplydesc, forumid;

        public AsyncNewReply(RecyclerView rvForumReply, String replymaker, String forumreplydesc, String forumid){
            this.rvForumReply = rvForumReply;
            this.replymaker = replymaker;
            this.forumreplydesc = forumreplydesc;
            this.forumid = forumid;
        }

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL(linkPost);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            }

            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);

                //setDoInput to true as we send data using json file
                conn.setDoInput(true);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ReplyMaker", replymaker);
                jsonObject.put("ForumReplyDescription", forumreplydesc);
                jsonObject.put("ForumID", forumid);
                String message = jsonObject.toString();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(message);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (ProtocolException e) {
                e.printStackTrace();
                return e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } catch (JSONException e) {
                e.printStackTrace();
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

                    return ("Unsuccessful!");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            new AsyncPost(rvForumReply, forumid);
        }
    }
}
