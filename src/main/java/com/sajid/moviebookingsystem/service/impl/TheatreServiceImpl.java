package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.TheatreDao;
import com.sajid.moviebookingsystem.entities.Theatre;
import com.sajid.moviebookingsystem.exceptions.TheatreDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.TheatreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TheatreServiceImpl implements TheatreService {

  @Autowired
  private TheatreDao theatreDao;

  @Override
  public Theatre acceptTheatreDetails(Theatre theatre) {
    return theatreDao.save(theatre);
  }

  @Override
  public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException {
    return theatreDao.findById(id)
        .orElseThrow(
            () -> new TheatreDetailsNotFoundException("Theatre not found for id: " + id)
        );
  }

  @Override
  public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException {
    Theatre savedTheatre = getTheatreDetails(id);

    if (isNotNullOrZero(theatre.getTheatreName())) {
      savedTheatre.setTheatreName(theatre.getTheatreName());
    }
    if (isNotNullOrZero(theatre.getTicketPrice())) {
      savedTheatre.setTicketPrice(theatre.getTicketPrice());
    }
    if (isNotNullOrZero(theatre.getCity())) {
      savedTheatre.setCity(theatre.getCity());
    }

    return theatreDao.save(theatre);
  }

  private boolean isNotNullOrZero(Object obj) {
    return obj != null;
  }

  private boolean isNotNullOrZero(int val) {
    return val != 0;
  }

  private boolean isNotNullOrZero(float val) {
    return val >= 0.1f;
  }

  @Override
  public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException {
    Theatre savedTheatre = getTheatreDetails(id);
    theatreDao.delete(savedTheatre);
    return true;
  }

  @Override
  public List<Theatre> getAllTheatreDetails() {
    return theatreDao.findAll();
  }
}