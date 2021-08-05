package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {
}
