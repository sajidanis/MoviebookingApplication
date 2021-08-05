package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreDao extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByTheatreName(String theatreName);
    List<Theatre> findByTicketPriceLessThan(float price);
    List<Theatre> findByTheatreNameContaining(String theatreName);
}
