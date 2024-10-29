package com.nextgen.movie_service.Repository;

import com.nextgen.movie_service.Entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepo extends JpaRepository<WatchList, Long> {
}