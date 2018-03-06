package com.epam.jap.test.movie.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class InMemoryMovieRepositoryTest {
    private InMemoryMovieRepository inMemoryMovieRepository = new InMemoryMovieRepository();

    @Before
    public void setUp() {
        inMemoryMovieRepository.loadRepository("test/com/epam/jap/test/movie/resource/movies_test.txt");
    }

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

    @Test
    public void shouldReadTestMoviesFile() throws URISyntaxException {
        Assert.assertEquals(5, inMemoryMovieRepository.movieCount());
    }

    @Test
    public void shouldReturn3MoviesDating1996 () {
        int count = inMemoryMovieRepository.filterByYearOfProduction(1996).movieCount();
        Assert.assertEquals(3, count);
    }

    @Test
    public void shouldReturn2MoviesWithRatingCountGreaterThan42 () {
        int count = inMemoryMovieRepository.filterByRatingCountMoreThan(42).movieCount();
        Assert.assertEquals(2, count);
    }

    @Test
    public void shouldReturn4MoviesWithRatingGreaterThan1_2 () {
        int count = inMemoryMovieRepository.filterByRatingBetterThan(1.2).movieCount();
        Assert.assertEquals(4, count);
    }

}