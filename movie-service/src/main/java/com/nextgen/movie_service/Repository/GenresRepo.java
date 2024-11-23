package com.nextgen.movie_service.Repository;
import com.nextgen.movie_service.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepo extends JpaRepository<Genres, Long> {

}
