package com.nextgen.movie_service.Repository;
import com.nextgen.movie_service.Entity.MovieLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLanguageRepo extends JpaRepository<MovieLanguage,Long> {
}