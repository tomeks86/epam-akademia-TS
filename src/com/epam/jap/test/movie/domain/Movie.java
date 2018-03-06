package com.epam.jap.test.movie.domain;


public class Movie {
    static class MovieBuilder {
        private String title;
        private Integer yearOfProduction;
        private Double rating;
        private Integer ratingCount;

        MovieBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        MovieBuilder withYearOfProduction(Integer yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        MovieBuilder withRating(Double rating) {
            this.rating = rating;
            return this;
        }

        MovieBuilder withRatingCount(Integer ratingCount) {
            this.ratingCount = ratingCount;
            return this;
        }

        Movie build() {
            return new Movie(title, yearOfProduction, rating, ratingCount);
        }
    }

    private String title;
    private Integer yearOfProduction;
    private Double rating;
    private Integer ratingCount;

    private Movie(String title, Integer yearOfProduction, Double rating, Integer ratingCount) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.rating = rating;
        this.ratingCount = ratingCount;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }
}
