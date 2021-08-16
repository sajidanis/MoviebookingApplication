package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.UserType;
import com.sajid.moviebookingsystem.exceptions.UserTypeDetailsNotFoundException;
import java.util.List;


public interface UserTypeService {
  UserType acceptUserTypeDetails(UserType userType);
  UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
  UserType getUserTypeDetailsFromUserTypeName(String userType) throws UserTypeDetailsNotFoundException;
  boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException;
  List<UserType> getAllUserTypeDetails();


}
