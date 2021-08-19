package com.sajid.moviebookingsystem;

import com.sajid.moviebookingsystem.dao.StatusDao;
import com.sajid.moviebookingsystem.entities.Movie;
import com.sajid.moviebookingsystem.entities.Status;
import com.sajid.moviebookingsystem.exceptions.MovieDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
@SpringBootApplication
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);
        System.out.println("Movie Booking Application");

        MovieService movieService = ctx.getBean(MovieService.class);

        StatusDao statusDao = ctx.getBean(StatusDao.class);
        Status status = new Status();
        status.setStatusName("RELEASED");
        statusDao.save(status);

        Movie movie = new Movie();
        movie.setMovieName("Inception");
        movie.setMovieDescription("Best Movie");
        movie.setCoverPhotoUrl("cover-photo");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2021, 1, 1, 0, 0, 0));
        movie.setStatus(status);
        movie.setTrailerUrl("trailer-url");
        Movie ret = movieService.acceptMovieDetails(movie);

        try {
            movieService.getMovieDetails(ret.getMovieId());
        } catch (MovieDetailsNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
