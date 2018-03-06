package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public interface RepositoryOperation {
    MovieRepository performOperation(MovieRepository movieRepository, String arg);
}
