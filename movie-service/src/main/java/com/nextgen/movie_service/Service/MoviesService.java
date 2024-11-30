package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.Movies;
import com.nextgen.movie_service.Repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepo moviesRepo;

    public Movies createMovie(Movies movie) {
        return moviesRepo.save(movie);
    }


    public List<Movies> getAllMovies() {
        return moviesRepo.findAll();
    }


    public Optional<Movies> getMovieById(Long id) {
        return moviesRepo.findById(id);
    }


    public Movies updateMovie(Long id, Movies updatedMovie) {
        if (moviesRepo.existsById(id)) {
            updatedMovie.setId(id);
            return moviesRepo.save(updatedMovie);
        } else {
            throw new RuntimeException("Movie not found with id: " + id);
        }
    }

    public void deleteMovie(Long id) {
        if (moviesRepo.existsById(id)) {
            moviesRepo.deleteById(id);
        } else {
            throw new RuntimeException("Movie not found with id: " + id);
        }
    }
}
