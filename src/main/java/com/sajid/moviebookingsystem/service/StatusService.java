package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.Status;
import com.sajid.moviebookingsystem.exceptions.StatusDetailsNotFoundException;
import java.util.List;


public interface StatusService {
  Status acceptStatusDetails(Status status);
  Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
  Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException;
  boolean deleteStatus(int id) throws StatusDetailsNotFoundException;
  List<Status> getAllStatusDetails();
}
