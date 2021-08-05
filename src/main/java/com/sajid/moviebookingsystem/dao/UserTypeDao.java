package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByUserTypeName(String userTypeName);
}
