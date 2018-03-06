package com.epam.jap.test.movie.service;

import com.epam.jap.test.movie.repository.MovieRepository;

public class OpFilterByYearOfProduction implements RepositoryOperation {
    @Override
    public MovieRepository performOperation(MovieRepository movieRepository, String arg) {
        try {
            Integer yearOfProduction = Integer.valueOf(arg);
            return movieRepository.filterByYearOfProduction(yearOfProduction);
        } catch (NumberFormatException e) {
            System.out.println("error parsing year of production from input");
        }
        return movieRepository;
    }
}
