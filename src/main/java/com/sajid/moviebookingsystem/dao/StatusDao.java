package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
    Status findByStatusName(String statusName);
}
