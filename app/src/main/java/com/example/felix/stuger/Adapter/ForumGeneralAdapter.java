package com.example.felix.stuger.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felix.stuger.ForumReplyActivity;
import com.example.felix.stuger.Model.ForumQuestion;
import com.example.felix.stuger.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForumGeneralAdapter extends RecyclerView.Adapter<ForumGeneralAdapter.ViewHolder> {

    Context context;
    ArrayList<ForumQuestion> listForumQuestion;

    public ForumGeneralAdapter(Context context, ArrayList<ForumQuestion> listForumQuestion){
        this.context = context;
        this.listForumQuestion = listForumQuestion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_forum_question, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ForumGeneralAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.bind(listForumQuestion.get(i));

        viewHolder.etSubmitAnswer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

        viewHolder.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = viewHolder.tvForumThread.getText().toString();
                String desc = viewHolder.tvForumDescription.getText().toString();
                String answer = viewHolder.etSubmitAnswer.getText().toString();

                if(answer.length() < 20){
                    Toast.makeText(context, "Jawaban minimal memiliki 20 karakter!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent();
                    intent.setClass(context, ForumReplyActivity.class);
                    String forumid = listForumQuestion.get(i).getForumID();

                    intent.putExtra("name", name);
                    intent.putExtra("desc", desc);
                    intent.putExtra("answer", answer);
                    intent.putExtra("forumid", forumid);

                    context.startActivity(intent);
                }
            }
        });

        viewHolder.tvForumThread.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String name = viewHolder.tvForumThread.getText().toString();
                String desc = viewHolder.tvForumDescription.getText().toString();
                String forumid = listForumQuestion.get(i).getForumID();

                OpenReply openReply = new OpenReply();

                openReply.openReply(name, desc, forumid);
                return false;
            }
        });

        viewHolder.questionAvatar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String name = viewHolder.tvForumThread.getText().toString();
                String desc = viewHolder.tvForumDescription.getText().toString();
                String forumid = listForumQuestion.get(i).getForumID();

                OpenReply openReply = new OpenReply();

                openReply.openReply(name, desc, forumid);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listForumQuestion.size();
    }

    public void setData(ArrayList<ForumQuestion> listForumQuestion){
        this.listForumQuestion = listForumQuestion;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvForumThread, tvForumDescription;
        EditText etSubmitAnswer;
        Button btnSubmit;
        CircleImageView questionAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvForumThread = itemView.findViewById(R.id.tv_forum_thread);
            tvForumDescription = itemView.findViewById(R.id.tv_forum_description);
            btnSubmit = itemView.findViewById(R.id.btn_submit_answer);
            etSubmitAnswer = itemView.findViewById(R.id.et_submit_answer);
            questionAvatar = itemView.findViewById(R.id.question_avatar);
        }

        public void bind(ForumQuestion forumQuestion) {
            tvForumThread.setText(forumQuestion.getForumThread());
            tvForumDescription.setText(forumQuestion.getForumDescription());
        }
    }

    private class OpenReply {
        public void openReply(String name, String desc, String forumid){
            Intent intent = new Intent();
            intent.setClass(context, ForumReplyActivity.class);

            intent.putExtra("name", name);
            intent.putExtra("desc", desc);
            intent.putExtra("forumid", forumid);

            context.startActivity(intent);
        }
    }
}
