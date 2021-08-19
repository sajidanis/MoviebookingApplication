package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.City;
import com.sajid.moviebookingsystem.exceptions.CityDetailsNotFoundException;
import java.util.List;


public interface CityService {

  City acceptCityDetails(City city);
  List<City> acceptMultipleCityDetails(List<City> cities);
  City updateCityDetails(int id, City city) throws CityDetailsNotFoundException;
  City getCityDetails(int id) throws CityDetailsNotFoundException;
  City getCityDetailsByCityName(String cityName) throws CityDetailsNotFoundException;
  boolean deleteCity(int id) throws CityDetailsNotFoundException;
  List<City> getAllCityDetails();
}
