package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.MovieGeners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenersRepo extends JpaRepository<MovieGeners, Long> {
}