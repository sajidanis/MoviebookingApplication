package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.exceptions.*;

/**
 * This will be used to initialize the data of all services
 */

public interface InitService {
    void init() throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException, UserTypeDetailsNotFoundException, UserNameAlreadyExistsException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
}
