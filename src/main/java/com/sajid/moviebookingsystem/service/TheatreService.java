package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.Theatre;
import com.sajid.moviebookingsystem.exceptions.TheatreDetailsNotFoundException;
import java.util.List;


public interface TheatreService {
  Theatre acceptTheatreDetails(Theatre theatre);
  Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException;
  Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException;
  boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException;
  List<Theatre> getAllTheatreDetails();
}
