package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.*;
import com.sajid.moviebookingsystem.entities.*;
import com.sajid.moviebookingsystem.exceptions.StatusDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private CityService cityService;

    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TheatreDao theatreDao;

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private BookingDao bookingDao;

    @Override
    public void init() {
        // The logic to store the data inside the database in different Tables

        /*
        Adding data to cities
         */
        createCities();

        /*
        Adding UserType
         */
        createUserTypes();

        /*
        Adding the Status
         */
        createStatuses();

        /*
        Adding Movies
         */
        createMovies();

        /*
        Adding Theatres
         */

        /*
        Adding MovieTheatres
         */

        /*
        Adding Users
         */

        /*
        Adding Booking
         */

    }

    private void createMovies() {
        Movie movie1 = new Movie();
        movie1.setMovieName("TITANIC");
        movie1.setTrailerUrl("trailer");
        movie1.setMovieDescription("Amazing Movie");
        movie1.setDuration(120);
        movie1.setReleaseDate(LocalDateTime.of(2001, 4, 28, 0, 0, 0));
        movie1.setCoverPhotoUrl("cover-photo");
        try {
            Status status = statusService.getStatusDetailsByStatusName("RELEASED");
            movie1.setStatus(status);
        } catch (StatusDetailsNotFoundException e) {
            Status status = new Status("RELEASED");
            statusService.acceptStatusDetails(status);
            movie1.setStatus(status);
        }
        movieService.acceptMovieDetails(movie1);
    }

    private void createStatuses() {
        List<Status> statuses = new ArrayList<>();
        statuses.add(new Status("UPCOMING"));
        statuses.add(new Status("RELEASED"));
        statuses.add(new Status("BLOCKED"));
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Customer"));
        userTypes.add(new UserType("Admin"));
        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Patna"));
        cities.add(new City("Bangalore"));
        cities.add(new City("Kolkata"));
        cities.add(new City("Mumbai"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
