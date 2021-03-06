package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.BookingDao;
import com.sajid.moviebookingsystem.entities.Booking;
import com.sajid.moviebookingsystem.exceptions.BookingDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.UserDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.BookingService;
import com.sajid.moviebookingsystem.service.MovieTheatreService;
import com.sajid.moviebookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  public MovieTheatreService movieTheatreService;

  @Autowired
  public UserService userService;

  @Autowired
  public BookingDao bookingDao;

  @Override
  public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
                                                              UserDetailsNotFoundException {
    movieTheatreService.getMovieTheatreDetails(booking.getMovieTheatre().getMovieTheatreId());
    userService.getUserDetails(booking.getUser().getUserId());
    bookingDao.save(booking);
    return booking;
  }

  @Override
  public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
    return bookingDao.findById(id)
        .orElseThrow(
            () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
        );
  }

  @Override
  public boolean deleteBooking(int id) throws BookingDetailsNotFoundException {
    Booking booking = getBookingDetails(id);
    bookingDao.delete(booking);
    return true;
  }

  @Override
  public List<Booking> getAllBookingDetails() {
    return bookingDao.findAll();
  }
}
