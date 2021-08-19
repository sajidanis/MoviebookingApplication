package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.MovieDao;
import com.sajid.moviebookingsystem.entities.Movie;
import com.sajid.moviebookingsystem.exceptions.MovieDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    /**
     * To talk with database I need to talk to MovieDao
     */
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        /*
          With the help of MovieDao we will save the movie
         */
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {
        /*
          Fetch the movie details based on the id
         */
        return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found by id: " + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);

        if (isNotNullOrZero(movie.getMovieName())) {
            savedMovie.setMovieName(movie.getMovieName());
        }
        if (isNotNullOrZero(movie.getMovieDescription())) {
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        if (isNotNullOrZero(movie.getReleaseDate())) {
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }

        savedMovie.setDuration(movie.getDuration());

        if (isNotNullOrZero(movie.getCoverPhotoUrl())) {
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }
        if (isNotNullOrZero(movie.getTrailerUrl())) {
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }
        if (isNotNullOrZero(movie.getStatus())) {
            savedMovie.setStatus(movie.getStatus());
        }

        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMovieDetails() {
        return movieDao.findAll();
    }
}
