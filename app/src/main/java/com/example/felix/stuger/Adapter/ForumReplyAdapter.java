package com.example.felix.stuger.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felix.stuger.Model.ForumReply;
import com.example.felix.stuger.R;

import java.util.ArrayList;

public class ForumReplyAdapter extends RecyclerView.Adapter<ForumReplyAdapter.ViewHolder> {

    Context context;
    ArrayList<ForumReply> listForumReply;

    public ForumReplyAdapter(Context context, ArrayList<ForumReply> listForumReply){
        this.context = context;
        this.listForumReply = listForumReply;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_forum_reply, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumReplyAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.bind(listForumReply.get(i));

        viewHolder.btnThumbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = listForumReply.get(i).getForumScore();
                score++;
                listForumReply.get(i).setForumScore(score);
                notifyDataSetChanged();
            }
        });

        viewHolder.btnThumbDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = listForumReply.get(i).getForumScore();
                score--;
                listForumReply.get(i).setForumScore(score);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listForumReply.size();
    }

    public void setData(ArrayList<ForumReply> listForumReply){
        this.listForumReply = listForumReply;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvForumReplyName, tvForumReplyDesc, tvForumScore;
        ImageButton btnThumbUp, btnThumbDown;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvForumReplyName = itemView.findViewById(R.id.tv_forum_reply_name);
            tvForumReplyDesc = itemView.findViewById(R.id.tv_forum_reply_desc);
            tvForumScore = itemView.findViewById(R.id.tv_forum_score);
            btnThumbUp = itemView.findViewById(R.id.btn_thumb_up);
            btnThumbDown = itemView.findViewById(R.id.btn_thumb_down);
        }

        public void bind(ForumReply forumReply){
            tvForumReplyName.setText(forumReply.getForumReplyName());
            tvForumReplyDesc.setText(forumReply.getForumReplyDesc());
            tvForumScore.setText(String.valueOf(forumReply.getForumScore()));
        }
    }
}
