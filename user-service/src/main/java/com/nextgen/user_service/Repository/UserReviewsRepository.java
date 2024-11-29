package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.ReviewKey;
import com.nextgen.user_service.Entity.UserReviews;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserReviewsRepository extends CassandraRepository<UserReviews, ReviewKey> {

}