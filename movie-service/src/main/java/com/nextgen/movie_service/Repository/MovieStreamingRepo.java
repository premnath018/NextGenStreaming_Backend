package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.MovieStreaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStreamingRepo extends JpaRepository<MovieStreaming, Long> {

}
