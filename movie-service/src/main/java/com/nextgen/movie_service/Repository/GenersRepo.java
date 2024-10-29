package com.nextgen.movie_service.Repository;
import com.nextgen.movie_service.Entity.Geners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenersRepo extends JpaRepository<Geners, Long> {

}
