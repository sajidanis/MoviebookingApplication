package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
    City findByCityName(String cityName);
}
