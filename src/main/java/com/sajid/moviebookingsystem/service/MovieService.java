package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.Movie;
import com.sajid.moviebookingsystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;

/**
 * This interface will define methods supported by
 * Movie Service
 */
public interface MovieService {
    /**
     * It should be able to take a movie request and save it to database
     */
    Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details based on movie id
     */
    Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to update the details of the existing movie
     */
    Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;

    /**
     * I want to delete a Movie
     */
    boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to get the list of all movies
     */
    List<Movie> getAllMovieDetails();
}
