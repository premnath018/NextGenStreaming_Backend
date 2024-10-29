package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.MovieActors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorsRepo extends JpaRepository<MovieActors, Long> {
}