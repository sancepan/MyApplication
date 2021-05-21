package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Book;
import com.example.myapplication.DATA.DataVideo;
import com.example.myapplication.R;

public class VideoAdapter extends  RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent,
                false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataVideo.title.length;
    }

    private class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, info;

        public VideoHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            info = (TextView) itemView.findViewById((R.id.info));
            itemView.setOnClickListener(this);

        }

        public void bindView(int position){
            /*title.setText(DataLecture.title[position]);
            info.setText(DataLecture.info[position]);*/
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Book.class);
            v.getContext().startActivity(intent);
        }
    }
}
