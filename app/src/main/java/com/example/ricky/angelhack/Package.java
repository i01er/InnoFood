package com.example.ricky.angelhack;

public class Package {

    private String id;
    private String title;
    private String main;
    private String season;
    private String body;
    private int image;

    public Package(String id, String title, String main, String season, String body, int image) {
        this.id = id;
        this.title = title;
        this.main = main;
        this.season = season;
        this.body = body;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMain() {
        return main;
    }

    public String getSeason() {
        return season;
    }

    public String getBody() {
        return body;
    }

    public int getImage() {
        return image;
    }
}

