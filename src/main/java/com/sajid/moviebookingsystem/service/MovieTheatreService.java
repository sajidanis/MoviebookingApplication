package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.MovieTheatre;
import com.sajid.moviebookingsystem.exceptions.MovieDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.TheatreDetailsNotFoundException;
import java.util.List;


public interface MovieTheatreService {
  MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
                                                                                  TheatreDetailsNotFoundException;
  MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
  boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
  List<MovieTheatre> getAllMovieTheatreDetails();
}
