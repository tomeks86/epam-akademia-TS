package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public class OpFilterByRatingCountMoreThan implements RepositoryOperation {
    @Override
    public MovieRepository performOperation(MovieRepository movieRepository, String arg) {
        try {
            Integer ratingCount = Integer.valueOf(arg);
            return movieRepository.filterByRatingCountMoreThan(ratingCount);
        } catch (NumberFormatException e) {
            System.out.println("error parsing rating count from input");
        }
        return movieRepository;
    }
}
