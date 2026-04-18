package org.example.model;

import java.time.LocalDateTime;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private int durationInMinutes;

    public Show(String id, Movie movie, Screen screen, LocalDateTime startTime, int durationInMinutes) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() { return id; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public LocalDateTime getStartTime() { return startTime; }
}
