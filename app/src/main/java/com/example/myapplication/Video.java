package com.example.myapplication;

public class Video {
    private String title;
    private String URL;
    private String preview;

    public Video(String title, String URL, String preview) {
        this.title = title;
        this.URL = URL;
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
