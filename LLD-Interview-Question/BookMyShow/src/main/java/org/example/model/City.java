package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String id;
    private String name;
    private List<Theatre> theatres;

    public City(String id, String name) {
        this.id = id;
        this.name = name;
        this.theatres = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Theatre> getTheatres() { return theatres; }
    public void addTheatre(Theatre theatre) { this.theatres.add(theatre); }
}
