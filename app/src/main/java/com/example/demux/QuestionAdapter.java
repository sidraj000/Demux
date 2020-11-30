package com.example.demux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private ArrayList<Question>mQuestions;

    public QuestionAdapter(ArrayList<Question> mQuestions) {
        this.mQuestions = mQuestions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View questionView = inflater.inflate(R.layout.item_question, parent, false);

        ViewHolder viewHolder = new ViewHolder(questionView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
    holder.mTextView.setText(mQuestions.get(i).text);
    holder.mTag1.setText(mQuestions.get(i).tags[0]);
    holder.mTag2.setText(mQuestions.get(i).tags[1]);
    holder.mTag3.setText(mQuestions.get(i).tags[2]);
    holder.mFreq.setText(mQuestions.get(i).freq);
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView,mTag1,mTag2,mTag3,mFreq;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.tvQuestion);
            mTag1=itemView.findViewById(R.id.tag1);
            mTag2=itemView.findViewById(R.id.tag2);
            mTag3=itemView.findViewById(R.id.tag3);
            mFreq=itemView.findViewById(R.id.tvFrequency);
        }
    }

}