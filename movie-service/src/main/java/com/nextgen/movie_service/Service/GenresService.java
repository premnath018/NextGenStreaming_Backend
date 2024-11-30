package com.nextgen.movie_service.Service;

import com.nextgen.movie_service.Entity.Genres;
import com.nextgen.movie_service.Repository.GenresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {

    @Autowired
    private GenresRepo genresRepo;


    public Genres createGenre(Genres genres) {
        return genresRepo.save(genres);
    }


    public List<Genres> getAllGenres() {
        return genresRepo.findAll();
    }


    public Optional<Genres> getGenreById(Long id) {
        return genresRepo.findById(id);
    }


    public Genres updateGenre(Long id, Genres updatedGenre) {
        if (genresRepo.existsById(id)) {
            updatedGenre.setId(id);
            return genresRepo.save(updatedGenre);
        } else {
            throw new RuntimeException("Genre not found with id: " + id);
        }
    }

    public void deleteGenre(Long id) {
        if (genresRepo.existsById(id)) {
            genresRepo.deleteById(id);
        } else {
            throw new RuntimeException("Genre not found with id: " + id);
        }
    }
}
