package com.sajid.moviebookingsystem.services.impl;

import com.sajid.moviebookingsystem.entities.Movie;
import com.sajid.moviebookingsystem.entities.Status;
import com.sajid.moviebookingsystem.exceptions.StatusDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.MovieService;
import com.sajid.moviebookingsystem.service.StatusService;
import com.sajid.moviebookingsystem.service.impl.MovieServiceImpl;
import com.sajid.moviebookingsystem.service.impl.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private StatusService statusService;

    Movie movie;
    Status status;

    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieName("NAME1");
        movie.setMovieDescription("description");
        movie.setCoverPhotoUrl("cover-photo");
        movie.setTrailerUrl("trailer");
        movie.setDuration(120);
        try {
            status = statusService.getStatusDetailsByStatusName("Released");
        } catch (StatusDetailsNotFoundException e) {
            status = statusService.acceptStatusDetails(new Status("Released"));
        }
        movie.setStatus(status);
        movie.setReleaseDate(LocalDateTime.of(2021, 3, 4, 0, 0));
    }

    /**
     * Test AcceptMovieDetails
     */
    @Test
    public void testAcceptMovieDetails(){
        System.out.println("Movie Service object " + movieService);
        /*
        Check if this method is able to save the movie
         */
        Movie savedMovie = movieService.acceptMovieDetails(movie);
        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotEquals(0, movie.getMovieId());
    }

    /*
      Test UpdateMovieDetails
     */

    /*
      Test getMovieDetails
     */

    /*
      Test deleteMovieDetails
     */
}
