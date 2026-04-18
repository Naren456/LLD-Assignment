package org.example.service;

import org.example.model.Movie;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MovieService {
    private final Map<String, Movie> movies = new ConcurrentHashMap<>();
    private final Map<String, List<Movie>> cityMovies = new ConcurrentHashMap<>();

    public void addMovie(Movie movie, String cityId) {
        movies.put(movie.getId(), movie);
        cityMovies.computeIfAbsent(cityId, k -> new ArrayList<>()).add(movie);
    }

    public List<Movie> getMoviesByCity(String cityId) {
        return cityMovies.getOrDefault(cityId, Collections.emptyList());
    }
}
