package com.example.felix.stuger.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.felix.stuger.Model.Leaderboard;
import com.example.felix.stuger.R;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    Context context;
    ArrayList<Leaderboard> listLeaderboard;

    public LeaderboardAdapter(Context context, ArrayList<Leaderboard> listLeaderboard){
        this.context = context;
        this.listLeaderboard = listLeaderboard;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_leaderboard, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(listLeaderboard.get(i));
    }

    @Override
    public int getItemCount() {
        return listLeaderboard.size();
    }

    public void setData(ArrayList<Leaderboard> listLeaderboard){
        this.listLeaderboard = listLeaderboard;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvLeaderboardName, tvLeaderboardTitle, tvLeaderboardScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLeaderboardName = itemView.findViewById(R.id.tv_leaderboard_name);
            tvLeaderboardTitle = itemView.findViewById(R.id.tv_leaderboard_title);
            tvLeaderboardScore = itemView.findViewById(R.id.tv_leaderboard_score);
        }

        public void bind(Leaderboard leaderboard){
            tvLeaderboardName.setText(leaderboard.getLeaderboardName());
            tvLeaderboardTitle.setText(leaderboard.getLeaderboardTitle());
            tvLeaderboardScore.setText(String.valueOf(leaderboard.getLeaderboardScore()));
        }
    }
}
