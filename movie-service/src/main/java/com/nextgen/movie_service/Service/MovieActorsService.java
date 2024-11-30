package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.MovieActors;
import com.nextgen.movie_service.Repository.MovieActorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieActorsService {

    @Autowired
    private MovieActorsRepo movieActorsRepo;



    public MovieActors createMovieActor(MovieActors movieActors) {
        return movieActorsRepo.save(movieActors);
    }


    public List<MovieActors> getAllMovieActors() {
        return movieActorsRepo.findAll();
    }


    public Optional<MovieActors> getMovieActorById(Long id) {
        return movieActorsRepo.findById(id);
    }


    public MovieActors updateMovieActor(Long id, MovieActors updatedMovieActors) {
        if (movieActorsRepo.existsById(id)) {
            updatedMovieActors.setId(id); // Ensure the ID stays the same
            return movieActorsRepo.save(updatedMovieActors);
        } else {
            throw new RuntimeException("Movie Actor not found with id: " + id);
        }
    }


    public void deleteMovieActor(Long id) {
        if (movieActorsRepo.existsById(id)) {
            movieActorsRepo.deleteById(id);
        } else {
            throw new RuntimeException("Movie Actor not found with id: " + id);
        }
    }
}
