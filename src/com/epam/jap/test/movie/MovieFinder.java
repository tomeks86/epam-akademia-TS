package com.epam.jap.test.movie;

import java.util.Scanner;

public class MovieFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your command?");
            String userInput = scanner.nextLine();
            System.out.println("User said " + userInput);
        }
    }
}
