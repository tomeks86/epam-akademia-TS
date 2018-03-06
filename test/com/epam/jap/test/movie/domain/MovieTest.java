package com.epam.jap.test.movie.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldCreateNewMovieWithBuilder() {
        String title = "some title";
        Integer yearOfProduction = 2018;
        Double rating = 2.5;
        Integer ratingCount = 15;
        Movie someMovie = new Movie.MovieBuilder()
                .withTitle(title)
                .withYearOfProduction(yearOfProduction)
                .withRating(rating)
                .withRatingCount(ratingCount)
                .build();

        Assert.assertEquals("some title", someMovie.getTitle());
        Assert.assertEquals(Integer.valueOf(2018), someMovie.getYearOfProduction());
        Assert.assertTrue(Math.abs(rating - someMovie.getRating()) < 1.e-10);
        Assert.assertEquals(ratingCount, someMovie.getRatingCount());
    }
}