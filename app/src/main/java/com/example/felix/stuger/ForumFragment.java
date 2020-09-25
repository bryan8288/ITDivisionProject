package com.example.felix.stuger;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.felix.stuger.Adapter.ForumGeneralAdapter;
import com.example.felix.stuger.Model.ForumQuestion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class ForumFragment extends Fragment {

    ArrayList<ForumQuestion> listForumQuestion;
    RecyclerView rvForumQuestion;
    RecyclerView.Adapter rvAdapter;
    String link = "http://192.168.1.8/api/services/ForumGeneralServices/getforumthread.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forum,container,false);

        Intent intent = this.getActivity().getIntent();
        listForumQuestion = new ArrayList<>();

        if(intent.getExtras() != null){
            String question = intent.getExtras().getString("question");

            //adding question from question activity
            ForumQuestion TestQuestion = new ForumQuestion();
            TestQuestion.setForumThread("Penanya 1");
            TestQuestion.setForumDescription(question);

            listForumQuestion.add(TestQuestion);
        }

        rvForumQuestion = v.findViewById(R.id.rv_forum_question);
        rvForumQuestion.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvForumQuestion.getContext(), DividerItemDecoration.VERTICAL);
        rvForumQuestion.addItemDecoration(dividerItemDecoration);

        final ForumGeneralAdapter forumGeneralAdapter = new ForumGeneralAdapter(getActivity(), listForumQuestion);
        rvForumQuestion.setAdapter(forumGeneralAdapter);

        new AsyncFetch(getActivity(), rvForumQuestion).execute();

        return v;
    }

    private class AsyncFetch extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL url = null;

        RecyclerView rvForumQuestion;
        Activity context;

        public AsyncFetch(Activity context, RecyclerView rvForumQuestion){
            this.context = context;
            this.rvForumQuestion = rvForumQuestion;
        }

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
            ArrayList<ForumQuestion> listForumQuestion = new ArrayList<>();

            try {
                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject jsonObject = jArray.getJSONObject(i);
                    ForumQuestion forumQuestion = new ForumQuestion();
                    forumQuestion.setForumID(jsonObject.getString("ForumID"));
                    forumQuestion.setForumThread(jsonObject.getString("ForumThreadMaker"));
                    forumQuestion.setForumDescription(jsonObject.getString("ForumDescription"));

                    listForumQuestion.add(forumQuestion);
                }

                final ForumGeneralAdapter leaderboardAdapter = new ForumGeneralAdapter(getActivity(), listForumQuestion);
                rvForumQuestion.setAdapter(leaderboardAdapter);

            } catch (JSONException e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
