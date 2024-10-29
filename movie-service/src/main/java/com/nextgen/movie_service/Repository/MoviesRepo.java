package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepo extends JpaRepository<Movies,Long> {
}