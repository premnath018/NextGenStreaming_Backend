package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.UserWishlist;
import com.nextgen.user_service.Entity.WishlistKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserWishlistRepository extends CassandraRepository<UserWishlist, WishlistKey> {

}