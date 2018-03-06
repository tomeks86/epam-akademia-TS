package com.epam.jap.test.movie.repository;

import com.epam.jap.test.movie.domain.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class InMemoryMovieRepository implements MovieRepository {
    private final List<Movie> movieList;

    public InMemoryMovieRepository() {
        movieList = new LinkedList<>();
    }

    @Override
    public void loadRepository(String location) {
        Path moviePath = FileSystems.getDefault().getPath(location);
        try (BufferedReader movieFile = Files.newBufferedReader(moviePath)) {
            String line;
            while ((line = movieFile.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
