package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.*;
import com.sajid.moviebookingsystem.entities.*;
import com.sajid.moviebookingsystem.exceptions.*;
import com.sajid.moviebookingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
    private UserService userService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieTheatreService movieTheatreService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private LanguageService languageService;

    List<City> cities = Arrays.asList(new City("Patna"), new City("Mumbai"), new City("Kolkata"), new City("Bangalore"));
    List<UserType> userTypes = Arrays.asList(new UserType("Customer"), new UserType("Admin"));
    List<Language> languages = Arrays.asList(new Language("English"), new Language("Hindi"), new Language("Bengali"));
    List<Status> statuses = Arrays.asList(new Status("Upcoming"), new Status("Released"), new Status("Blocked"));

    User customer = new User();
    Theatre theatre1 = new Theatre();
    Theatre theatre2 = new Theatre();
    Movie movie1 = new Movie();
    Movie movie2 = new Movie();
    MovieTheatre movieTheatre1 = new MovieTheatre();

    @Override
    public void init() throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException, UserTypeDetailsNotFoundException, UserNameAlreadyExistsException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
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
        createTheatres();

        /*
        Adding MovieTheatres
         */
        createMovieTheatre();
        /*
        Adding Users
         */
        createUser();

        /*
        Adding Booking
         */
        createBooking();
    }

    private void createBooking() throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        Booking booking = new Booking();
        booking.setBookingDate(LocalDateTime.of(2019, 1, 8, 0, 10));
        booking.setUser(customer);
        booking.setNoOfSeats(150);
        booking.setMovieTheatre(movieTheatre1);
        bookingService.acceptBookingDetails(booking);
    }

    private void createUser() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        customer.setFirstName("Emma");
        customer.setLastName("Stone");
        customer.setUsername("emma123stone");
        customer.setPassword("emma@amme");
        customer.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));
        customer.setUserType(userTypes.get(0));
        Language language = languageService.acceptLanguageDetails(languages.get(0));
        customer.setLanguage(language);
        customer = userService.acceptUserDetails(customer);
    }

    private void createMovieTheatre() throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieTheatre1.setMovie(movie1);
        movieTheatre1.setTheatre(theatre2);
        movieTheatreService.acceptMovieTheatreDetails(movieTheatre1);
    }

    private void createTheatres() {
        theatre1.setTheatreName("Urvashi Cinema");
        theatre1.setTicketPrice(500);
        theatre1.setCity(cities.get(0));
        theatre1 = theatreService.acceptTheatreDetails(theatre1);

        theatre2.setTheatreName("Cinepolis Multiplex");
        theatre2.setTicketPrice(600);
        theatre2.setCity(cities.get(1));
        theatre2 = theatreService.acceptTheatreDetails(theatre2);
    }

    private void createMovies() {
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
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUserTypes() {
        userTypes.forEach(userType -> userTypeService.acceptUserTypeDetails(userType));
    }

    private void createCities() {
        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
