package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
