package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.RecommendationKey;
import com.nextgen.user_service.Entity.UserRecommendations;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRecommendationsRepository extends CassandraRepository<UserRecommendations, RecommendationKey> {

}