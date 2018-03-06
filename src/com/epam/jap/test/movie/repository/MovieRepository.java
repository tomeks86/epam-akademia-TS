package com.epam.jap.test.movie.repository;

import com.epam.jap.test.movie.domain.Movie;

import java.util.List;

public interface MovieRepository {
    public MovieRepository copy();

    public void loadRepository(String location);

    public List<Movie> getMovieList();

    public void showTitles();

    public int movieCount();

    public MovieRepository filterByRatingBetterThan(double rating);

    public MovieRepository filterByYearOfProduction(int year);

    public MovieRepository filterByRatingCountMoreThan(int ratingCount);
}
