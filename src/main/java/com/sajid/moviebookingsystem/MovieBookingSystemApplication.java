package com.sajid.moviebookingsystem;

import com.sajid.moviebookingsystem.dao.MovieDao;
import com.sajid.moviebookingsystem.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
@SpringBootApplication
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);
        MovieDao movieDao = ctx.getBean(MovieDao.class);
        /*
          I should be able to save the data
         */
        Movie movie = new Movie();
        movie.setMovieName("Tenet");
        movie.setMovieDescription("Awesome Movie");
        movie.setReleaseDate(LocalDateTime.of(2021,4,27, 0, 0, 0));
        movie.setDuration(150);
        movie.setCoverPhotoUrl("cover-photo-url");
        movie.setTrailerUrl("trailer-url");

        System.out.println("Movie: " + movie);
        System.out.println("Running Spring Boot Web App");

        System.out.println("Saving the movie");
        Movie savedObject = movieDao.save(movie);
        System.out.println(savedObject);
    }

}
