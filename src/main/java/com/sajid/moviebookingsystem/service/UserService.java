package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.User;
import com.sajid.moviebookingsystem.exceptions.UserDetailsNotFoundException;
import com.sajid.moviebookingsystem.exceptions.UserNameAlreadyExistsException;
import com.sajid.moviebookingsystem.exceptions.UserTypeDetailsNotFoundException;


public interface UserService {

  User acceptUserDetails(User user)
      throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

  User getUserDetails(int id) throws UserDetailsNotFoundException;

  User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

  User updateUserDetails(int id, User user)
      throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;
}
