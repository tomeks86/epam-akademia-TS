package com.epam.jap.test.movie.repository;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryMovieRepositoryTest {

    @Test
    public void shouldParseMovie() {
        String movieLine = "(Land Before Time III: The Time of the Great Giving,1995,1.6666666666666667,6)";
        String[] fields = InMemoryMovieRepository.parseMovie(movieLine);

        Assert.assertEquals("Land Before Time III: The Time of the Great Giving", fields[0]);
        Assert.assertEquals("1995", fields[1]);
        Assert.assertEquals("1.6666666666666667", fields[2]);
        Assert.assertEquals("6", fields[3]);

    }

    @Test
    public void shouldParseMovieWithDifficultTitle() {
        String movieLine = "(Land Before Time III:,, The,, Time of the Great Giving,1995,1.6666666666666667,6)";
        String[] fields = InMemoryMovieRepository.parseMovie(movieLine);

        Assert.assertEquals("Land Before Time III:,, The,, Time of the Great Giving", fields[0]);
        Assert.assertEquals("1995", fields[1]);
        Assert.assertEquals("1.6666666666666667", fields[2]);
        Assert.assertEquals("6", fields[3]);

    }

}