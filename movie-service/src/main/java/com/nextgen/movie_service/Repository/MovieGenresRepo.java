package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.MovieGenres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenresRepo extends JpaRepository<MovieGenres, Long> {
}