package com.sajid.moviebookingsystem;

import com.sajid.moviebookingsystem.dao.StatusDao;
import com.sajid.moviebookingsystem.entities.Movie;
import com.sajid.moviebookingsystem.entities.Status;
import com.sajid.moviebookingsystem.exceptions.MovieDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.InitService;
import com.sajid.moviebookingsystem.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
@SpringBootApplication
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);
        System.out.println("Movie Booking Application");
    }

    @Bean
    CommandLineRunner init(InitService initService){
        return args -> {
            initService.init();
        };
    }

}
