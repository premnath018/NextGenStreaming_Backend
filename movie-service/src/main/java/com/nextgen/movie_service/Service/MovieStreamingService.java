package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.MovieStreaming;
import com.nextgen.movie_service.Repository.MovieStreamingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieStreamingService {

    @Autowired
    private MovieStreamingRepo movieStreamingRepo;


    public MovieStreaming createMovieStreaming(MovieStreaming movieStreaming) {
        return movieStreamingRepo.save(movieStreaming);
    }


    public List<MovieStreaming> getAllMovieStreamings() {
        return movieStreamingRepo.findAll();
    }


    public Optional<MovieStreaming> getMovieStreamingById(Long id) {
        return movieStreamingRepo.findById(id);
    }


    public MovieStreaming updateMovieStreaming(Long id, MovieStreaming updatedMovieStreaming) {
        if (movieStreamingRepo.existsById(id)) {
            updatedMovieStreaming.setId(id);
            return movieStreamingRepo.save(updatedMovieStreaming);
        } else {
            throw new RuntimeException("Movie Streaming not found with id: " + id);
        }
    }

    public void deleteMovieStreaming(Long id) {
        if (movieStreamingRepo.existsById(id)) {
            movieStreamingRepo.deleteById(id);
        } else {
            throw new RuntimeException("Movie Streaming not found with id: " + id);
        }
    }
}
