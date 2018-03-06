package com.epam.jap.test.movie;

import com.epam.jap.test.movie.repository.InMemoryMovieRepository;
import com.epam.jap.test.movie.repository.MovieRepository;

import java.util.Scanner;

public class MovieFinder {

    public static void main(String[] args) {
        MovieRepository movieRepository = new InMemoryMovieRepository();
        movieRepository.loadRepository("src/com/epam/jap/test/movie/resources/movies.txt");
        System.out.println("Loaded " + movieRepository.movieCount() + " movies");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your command?");
            String userInput = scanner.nextLine();
            System.out.println("User said " + userInput);
        }
    }
}
