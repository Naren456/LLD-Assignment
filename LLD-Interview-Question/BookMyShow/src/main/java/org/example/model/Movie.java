package org.example.model;

public class Movie {
    private String id;
    private String title;
    private int durationInMinutes;
    private String language;

    public Movie(String id, String title, int durationInMinutes, String language) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.language = language;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
}
