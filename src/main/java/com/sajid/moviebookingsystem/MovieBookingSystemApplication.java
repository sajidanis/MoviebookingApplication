package com.sajid.moviebookingsystem;

import com.sajid.moviebookingsystem.service.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingSystemApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);
        System.out.println("Movie Booking Application");
    }

    @Bean
    CommandLineRunner init(InitService initService){
        return args -> initService.init();
    }

}
