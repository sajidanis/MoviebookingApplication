package com.sajid.moviebookingsystem.service.impl;

import com.sajid.moviebookingsystem.dao.UserTypeDao;
import com.sajid.moviebookingsystem.entities.UserType;
import com.sajid.moviebookingsystem.exceptions.UserTypeDetailsNotFoundException;
import com.sajid.moviebookingsystem.service.UserTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserTypeServiceImpl implements UserTypeService {
  @Autowired
  private UserTypeDao userTypeDao;

  @Override
  public UserType acceptUserTypeDetails(UserType userType) {
    return userTypeDao.save(userType);
  }

  @Override
  public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException {
    return userTypeDao.findById(id)
        .orElseThrow(
            () -> new UserTypeDetailsNotFoundException("UserType not found with id: " + id)
        );
  }

  @Override
  public UserType getUserTypeDetailsFromUserTypeName(String userTypeName) throws UserTypeDetailsNotFoundException {
    return userTypeDao.findByUserTypeName(userTypeName)
        .orElseThrow(
            () -> new UserTypeDetailsNotFoundException("UserType not found with userTypeName: " + userTypeName)
        );
  }

  @Override
  public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException {
    UserType userType = getUserTypeDetails(id);
    userTypeDao.delete(userType);
    return true;
  }

  @Override
  public List<UserType> getAllUserTypeDetails() {
    return userTypeDao.findAll();
  }

}
