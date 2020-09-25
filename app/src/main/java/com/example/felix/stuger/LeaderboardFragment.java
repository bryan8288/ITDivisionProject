package com.example.felix.stuger;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.felix.stuger.Adapter.LeaderboardAdapter;
import com.example.felix.stuger.Model.Leaderboard;

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

public class LeaderboardFragment extends Fragment {

    ArrayList<Leaderboard> listLeaderboard;
    RecyclerView rvLeaderboard;
    RecyclerView.Adapter rvAdapter;
    String link = "http://192.168.1.8/api/services/AchievementServices/getachievement.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        listLeaderboard = new ArrayList<>();

        rvLeaderboard = v.findViewById(R.id.rv_leaderboard);
        rvLeaderboard.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvLeaderboard.getContext(), DividerItemDecoration.VERTICAL);
        rvLeaderboard.addItemDecoration(dividerItemDecoration);

        final LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(getActivity(), listLeaderboard);
        rvLeaderboard.setAdapter(leaderboardAdapter);

        new AsyncFetch(getActivity(), rvLeaderboard).execute();

        return v;
    }

    private class AsyncFetch extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL url = null;

        RecyclerView rvLeaderboard;
        Activity context;

        public AsyncFetch(Activity context, RecyclerView rvLeaderboard){
            this.context = context;
            this.rvLeaderboard = rvLeaderboard;
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

                final LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(getActivity(), listLeaderboard);
                rvLeaderboard.setAdapter(leaderboardAdapter);

            } catch (JSONException e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
