package com.epam.jap.test.movie.repository;

import com.epam.jap.test.movie.domain.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InMemoryMovieRepository implements MovieRepository {
    private final List<Movie> movieList;

    public InMemoryMovieRepository() {
        movieList = new LinkedList<>();
    }

    public InMemoryMovieRepository(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public void loadRepository(String location) {
        Path moviePath = FileSystems.getDefault().getPath(location);
        try (BufferedReader movieFile = Files.newBufferedReader(moviePath)) {
            String line;
            while ((line = movieFile.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] fields = parseMovie(line);
                    try {
                        String title = fields[0];
                        Integer yearOfProduction = Integer.valueOf(fields[1]);
                        Double rating = Double.valueOf(fields[2]);
                        Integer ratingCount = Integer.valueOf(fields[3]);
                        Movie movie = new Movie.MovieBuilder()
                                .withTitle(title)
                                .withYearOfProduction(yearOfProduction)
                                .withRating(rating)
                                .withRatingCount(ratingCount)
                                .build();
                        movieList.add(movie);
                    } catch (NumberFormatException e) {
                        System.out.println("Can't parse this line, skipping: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int movieCount() {
        return movieList.size();
    }

    @Override
    public MovieRepository filterByRatingBetterThan(double rating) {
        List<Movie> filtered = movieList.stream()
                .filter(m -> m.getRating() > rating)
                .collect(Collectors.toList());
        return new InMemoryMovieRepository(filtered);
    }

    @Override
    public MovieRepository filterByYearOfProduction(int year) {
        List<Movie> filtered = movieList.stream()
                .filter(m -> m.getYearOfProduction() == year)
                .collect(Collectors.toList());
        return new InMemoryMovieRepository(filtered);
    }

    @Override
    public MovieRepository filterByRatingCountMoreThan(int ratingCount) {
        List<Movie> filtered = movieList.stream()
                .filter(m -> m.getRatingCount() > ratingCount)
                .collect(Collectors.toList());
        return new InMemoryMovieRepository(filtered);
    }

    public static String[] parseMovie(String line) {
        Pattern pt = Pattern.compile("^\\((.+),(.+),(.+),(.+)\\)$");
        String[] fields = new String[4];
        for (int i = 0; i < 4; i++) {
            fields[i] = "";
        }
        Matcher matcher = pt.matcher(line);
        if (matcher.matches()) {
            for (int i = 0; i < 4; i++) {
                fields[i] = matcher.group(i + 1);
            }
        }
        return fields;
    }


}
