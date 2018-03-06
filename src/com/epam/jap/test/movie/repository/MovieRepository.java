package com.epam.jap.test.movie.repository;

public interface MovieRepository {
    public void loadRepository(String location);

    public int movieCount();

    public MovieRepository filterByRatingBetterThan(double rating);

    public MovieRepository filterByYearOfProduction(int year);

    public MovieRepository filterByRatingCountMoreThan(int ratingCount);
}
