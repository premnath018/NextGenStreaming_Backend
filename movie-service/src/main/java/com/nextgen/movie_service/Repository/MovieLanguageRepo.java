package com.nextgen.movie_service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLanguageRepo extends JpaRepository<MovieLanguageRepo, Long> {
}