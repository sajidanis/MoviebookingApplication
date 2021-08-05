package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieName(String movieName);
    List<Movie> findByMovieNameAndDuration(String name, int duration);
    List<Movie> findByReleaseDateBetween(LocalDateTime start, LocalDateTime end);
    List<Movie> findByDurationGreaterThanEqual(int duration);
    List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);
    List<Movie> findByMovieNameContaining(String movieName);
    List<Movie> findByMovieNameIgnoreCase(String movieName);
}
