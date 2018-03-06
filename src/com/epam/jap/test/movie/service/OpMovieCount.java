package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public class OpMovieCount implements RepositoryOperation {
    @Override
    public MovieRepository performOperation(MovieRepository movieRepository, String arg) {
        System.out.println(movieRepository.movieCount());
        return movieRepository;
    }
}
