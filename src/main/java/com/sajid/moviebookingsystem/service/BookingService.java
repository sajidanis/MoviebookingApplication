package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.Booking;
import com.sajid.moviebookingsystem.exceptions.BookingDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.UserDetailsNotFoundException;
import java.util.List;


public interface BookingService {

  Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
                                                              UserDetailsNotFoundException;
  Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
  boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
  List<Booking> getAllBookingDetails();

}
