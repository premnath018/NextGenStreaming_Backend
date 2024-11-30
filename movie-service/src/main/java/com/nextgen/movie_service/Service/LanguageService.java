package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.Language;
import com.nextgen.movie_service.Repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    public Language createLanguage(Language language) {
        return languageRepo.save(language);
    }


    public List<Language> getAllLanguages() {
        return languageRepo.findAll();
    }

    public Optional<Language> getLanguageById(Long id) {
        return languageRepo.findById(id);
    }


    public Language updateLanguage(Long id, Language updatedLanguage) {
        if (languageRepo.existsById(id)) {
            updatedLanguage.setId(id);  // Ensure the ID is set before saving
            return languageRepo.save(updatedLanguage);
        } else {
            throw new RuntimeException("Language not found with id: " + id);
        }
    }


    public void deleteLanguage(Long id) {
        if (languageRepo.existsById(id)) {
            languageRepo.deleteById(id);
        } else {
            throw new RuntimeException("Language not found with id: " + id);
        }
    }
}
