package com.sajid.moviebookingsystem.service;

import com.sajid.moviebookingsystem.entities.Language;
import com.sajid.moviebookingsystem.exceptions.LanguageDetailsNotFoundException;
import java.util.List;


public interface LanguageService {

  Language acceptLanguageDetails(Language language);
  Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException;
  Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException;
  boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException;
  List<Language> getAllLanguageDetails();
}
