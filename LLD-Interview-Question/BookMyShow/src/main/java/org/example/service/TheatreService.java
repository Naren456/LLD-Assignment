package org.example.service;

import org.example.model.Screen;
import org.example.model.Theatre;
import org.example.model.Show;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TheatreService {
    private final Map<String, Theatre> theatres = new ConcurrentHashMap<>();
    private final Map<String, List<Show>> theatreShows = new ConcurrentHashMap<>();

    public void addTheatre(Theatre theatre) {
        theatres.put(theatre.getId(), theatre);
    }

    public void addShow(Show show) {
        theatreShows.computeIfAbsent(show.getScreen().getId(), k -> new ArrayList<>()).add(show);
    }

    public List<Theatre> getTheatresByCity(String cityId) {
        return theatres.values().stream()
                .filter(t -> t.getId().contains(cityId)) // Simplified search
                .toList();
    }
}
