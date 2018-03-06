package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public class OpFilterByRatingBetterThan implements RepositoryOperation {
    @Override
    public MovieRepository performOperation(MovieRepository movieRepository, String arg) {
        try {
            Double rating = Double.valueOf(arg);
            return movieRepository.filterByRatingBetterThan(rating);
        } catch (NumberFormatException e) {
            System.out.println("error parsing rating from input");
        }
        return movieRepository;
    }
}
