package com.sajid.moviebookingsystem.dao;

import com.sajid.moviebookingsystem.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    Optional<Language> findByLanguageName(String languageName);
}
