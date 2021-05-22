package com.example.myapplication.Objects;

import android.net.Uri;

public class NewsCard {
    Uri uri;
    String date, info, href;

    public NewsCard(Uri uri, String date, String info, String href) {
        this.uri = uri;
        this.date = date;
        this.info = info;
        this.href = href;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
