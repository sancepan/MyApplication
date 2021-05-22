package com.example.myapplication.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DATA.DataLecture;
import com.example.myapplication.Fragments.News;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Objects.NewsCard;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends  RecyclerView.Adapter{

    ArrayList<NewsCard> newsCards = new ArrayList<>();

    public NewsAdapter(ArrayList<NewsCard> newsCards){
        this.newsCards = newsCards;
    }

    // Функция присвоения item_news всем элементам списка RecycleView
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsAdapter.NewsHolder(view);
    }

    // Функция item_lecture согласно позиции элемента в списке RecycleView
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NewsAdapter.NewsHolder) holder).bindView(position);
    }

    // функция получения количества элементов списка RecycleView
    @Override
    public int getItemCount() {
        return newsCards.size();
    }

    // Создание Холдера для адаптера
    private class NewsHolder extends RecyclerView.ViewHolder {

        private TextView date, info;
        private ImageView img;

        // Функция присвоения ссылок на элементы itemView
        public NewsHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            date = (TextView) itemView.findViewById(R.id.date);
            info = (TextView) itemView.findViewById((R.id.info));
        }

        // Функция заполнения itemView согласно позиции элемента в списке
        public void bindView(int position) {
            Picasso.with(img.getContext()).load(newsCards.get(position).getUri()).into(img);
            //img.setImageURI(Uri.parse("https://c.wallhere.com/photos/f3/82/mountains_reflection_wood_canada_colors-683509.jpg!d"));
            date.setText(newsCards.get(position).getDate());
            info.setText(newsCards.get(position).getInfo());
        }
    }
}
