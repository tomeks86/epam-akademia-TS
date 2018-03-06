package com.epam.jap.test.movie;

import com.epam.jap.test.movie.repository.InMemoryMovieRepository;
import com.epam.jap.test.movie.repository.MovieRepository;

import java.util.Scanner;

public class MovieFinder {

    public static void main(String[] args) {
        MovieRepository movieRepository = new InMemoryMovieRepository();
        MovieRepository actualMovieRepository = movieRepository.copy();
        movieRepository.loadRepository("src/com/epam/jap/test/movie/resources/movies.txt");
        System.out.println("Loaded " + movieRepository.movieCount() + " movies");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("Exit")) {
            System.out.println("Your command?");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "ShowMovieCount":
                    System.out.println(actualMovieRepository.movieCount());
                    break;
                case "ShowTitles":
                    actualMovieRepository.showTitles();
                    break;
                case "FilterByRatingBetterThan":
                    try {
                        Double rating = Double.valueOf(scanner.nextLine());
                        actualMovieRepository = actualMovieRepository.filterByRatingBetterThan(rating);
                    } catch (NumberFormatException e) {
                        System.out.println("error parsing rating from input");
                    }
                    break;
                case "FilterByYearOfProduction":
                    try {
                        Integer yearOfProduction = Integer.valueOf(scanner.nextLine());
                        actualMovieRepository = actualMovieRepository.filterByYearOfProduction(yearOfProduction);
                    } catch (NumberFormatException e) {
                        System.out.println("error parsing year of production from input");
                    }
                    break;
                case "FilterByRatingCountMoreThan":
                    try {
                        Integer ratingCount = Integer.valueOf(scanner.nextLine());
                        actualMovieRepository = actualMovieRepository.filterByRatingCountMoreThan(ratingCount);
                    } catch (NumberFormatException e) {
                        System.out.println("error parsing rating count from input");
                    }
                    break;
                case "Reset":
                    actualMovieRepository = movieRepository.copy();
                    break;
//                default:
            }
        }
    }
}
