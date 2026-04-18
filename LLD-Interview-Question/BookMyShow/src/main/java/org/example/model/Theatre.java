package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String id;
    private String name;
    private String cityId;
    private List<Screen> screens;

    public Theatre(String id, String name, String cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.screens = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Screen> getScreens() { return screens; }
    public void addScreen(Screen screen) { this.screens.add(screen); }
}
