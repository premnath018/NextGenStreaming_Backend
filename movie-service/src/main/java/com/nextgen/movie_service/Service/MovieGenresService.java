package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.MovieGenres;
import com.nextgen.movie_service.Repository.MovieGenresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieGenresService {

    @Autowired
    private MovieGenresRepo movieGenresRepo;

    // Get all movie genres
    public List<MovieGenres> getAllMovieGenres() {
        return movieGenresRepo.findAll();
    }

    // Get movie genre by ID
    public Optional<MovieGenres> getMovieGenreById(Long id) {
        return movieGenresRepo.findById(id);
    }

    // Add a new movie genre
    public MovieGenres addMovieGenre(MovieGenres movieGenre) {
        return movieGenresRepo.save(movieGenre);
    }

    // Update an existing movie genre
    public MovieGenres updateMovieGenre(Long id, MovieGenres updatedMovieGenre) {
        return movieGenresRepo.findById(id).map(existing -> {
            existing.setMovie(updatedMovieGenre.getMovie());
            existing.setGenre(updatedMovieGenre.getGenre());
            return movieGenresRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("MovieGenre not found with id: " + id));
    }

    // Delete a movie genre
    public void deleteMovieGenre(Long id) {
        movieGenresRepo.deleteById(id);
    }
}
