package com.example.myapplication.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapters.EqualSpacingItemDecoration;
import com.example.myapplication.Adapters.NewsAdapter;
import com.example.myapplication.Adapters.ObjectsAdapter;
import com.example.myapplication.Objects.NewsCard;
import com.example.myapplication.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class News extends Fragment {

    /*String html = "<html><head><title>Коты учатся кодить</title>"
            + "<body><p>Коты умеют <del>ш</del>кодить.<br> Они великие программисты." +
            "<p>А еще они умеют мяукать.</p>" +
            "<a href='http://developer.alexanderklimov.ru'>Подробности здесь</a>" +
            "</body></html>";

    Document doc = Jsoup.parse(html);*/

    ArrayList<NewsCard> newsCardList = new ArrayList<>();

    private NewsAdapter adapter;
    private Document doc;
    private Thread secThread;
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        init(v);

        /*String title = doc.html();
        newsText = (TextView) v.findViewById(R.id.news);
        newsText.setText(title);*/



        return v;
    }

    private void init(View v){

        adapter = new NewsAdapter(newsCardList);

        RecyclerView recyclerView = v.findViewById(R.id.news);

        // Задаем адаптер и менеджер для RecycleView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        runnable = new Runnable() {
            @Override
            public void run() {
                getWeb();
            }
        };
        secThread = new Thread(runnable);
        secThread.start();
    }


    private void getWeb(){
        try {
            doc = Jsoup.connect("https://www.mirea.ru/news/").get();

            for (Element e : doc.select("div.uk-card")) {
                String img = e.getElementsByTag("img").attr("abs:data-src");
                Uri uri = Uri.parse(img);
                Log.d("MyLog", uri.toString());
                String date = e.getElementsByClass("uk-margin-small-bottom uk-text-small").text();
                String info = e.select("a.uk-link-reset").text();
                String href = doc.select("a.uk-link-reset").attr("abs:href");

                newsCardList.add(new NewsCard(uri, date, info, href));
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Document document = Jsoup.connect("https://www.mirea.ru/news/").get();
    Elements contentElem = document.select("div > a.uk-link-reset:nth-child(1)");
    newsText.setText(document.html());*/



}
