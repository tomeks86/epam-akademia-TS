package com.epam.jap.test.movie;

import com.epam.jap.test.movie.repository.InMemoryMovieRepository;
import com.epam.jap.test.movie.repository.MovieRepository;
import com.epam.jap.test.movie.service.*;

import java.util.Scanner;

public class MovieFinder {

    public static void main(String[] args) {
        MovieRepository movieRepository = new InMemoryMovieRepository();
        MovieRepository actualMovieRepository = movieRepository.copy();
        movieRepository.loadRepository(args[0]);
        System.out.println("Loaded " + movieRepository.movieCount() + " movies");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        String arg = "";
        RepositoryOperation operation = null;
        while (!userInput.equals("Exit")) {
            System.out.println("Your command?");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "ShowMovieCount":
                    operation = new OpMovieCount();
                    break;
                case "ShowTitles":
                    operation = new OpShowTitles();
                    break;
                case "FilterByRatingBetterThan":
                    arg = scanner.nextLine();
                    operation = new OpFilterByRatingBetterThan();
                    break;
                case "FilterByYearOfProduction":
                    arg = scanner.nextLine();
                    operation = new OpFilterByYearOfProduction();
                    break;
                case "FilterByRatingCountMoreThan":
                    arg = scanner.nextLine();
                    operation = new OpFilterByRatingBetterThan();
                    break;
                case "Reset":
                    actualMovieRepository = movieRepository.copy();
                    break;
            }
            if (operation != null) {
                actualMovieRepository = operation.performOperation(actualMovieRepository, arg);
                operation = null;
                arg = "";
            }
        }
    }
}
