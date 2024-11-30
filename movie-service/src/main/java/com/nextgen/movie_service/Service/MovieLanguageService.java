package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.MovieLanguage;
import com.nextgen.movie_service.Repository.MovieLanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieLanguageService {

    @Autowired
    private MovieLanguageRepo movieLanguageRepo;


    public List<MovieLanguage> getAllMovieLanguages() {
        return movieLanguageRepo.findAll();
    }


    public Optional<MovieLanguage> getMovieLanguageById(Long id) {
        return movieLanguageRepo.findById(id);
    }


    public MovieLanguage addMovieLanguage(MovieLanguage movieLanguage) {
        return movieLanguageRepo.save(movieLanguage);
    }


    public MovieLanguage updateMovieLanguage(Long id, MovieLanguage updatedMovieLanguage) {
        return movieLanguageRepo.findById(id).map(existing -> {
            existing.setMovies(updatedMovieLanguage.getMovies());
            existing.setLanguage(updatedMovieLanguage.getLanguage());
            return movieLanguageRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("MovieLanguage not found with id: " + id));
    }


    public void deleteMovieLanguage(Long id) {
        movieLanguageRepo.deleteById(id);
    }
}
