package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public interface RepositoryOperation {
    public MovieRepository performOperation(MovieRepository movieRepository);
}
