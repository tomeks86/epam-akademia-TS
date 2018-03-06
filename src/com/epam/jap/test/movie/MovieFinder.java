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
        String command = "";
        String arg = "";
        RepositoryOperation operation = null;
        while (!userInput.equals("Exit")) {
            System.out.println("Your command?");
            userInput = scanner.nextLine();
            String[] commands = userInput.split("\\s");
            if (commands.length > 1) {
                command = commands[0];
                arg = commands[1];
            } else {
                command = commands[0];
            }
            switch (command) {
                case "ShowMovieCount":
                    operation = new OpMovieCount();
                    break;
                case "ShowTitles":
                    operation = new OpShowTitles();
                    break;
                case "FilterByRatingBetterThan":
                    operation = new OpFilterByRatingBetterThan();
                    break;
                case "FilterByYearOfProduction":
                    operation = new OpFilterByYearOfProduction();
                    break;
                case "FilterByRatingCountMoreThan":
                    operation = new OpFilterByRatingCountMoreThan();
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
