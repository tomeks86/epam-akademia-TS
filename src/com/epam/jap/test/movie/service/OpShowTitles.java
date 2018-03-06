package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public class OpShowTitles implements RepositoryOperation {
    @Override
    public MovieRepository performOperation(MovieRepository movieRepository, String arg) {
        movieRepository.showTitles();
        return movieRepository;
    }
}
