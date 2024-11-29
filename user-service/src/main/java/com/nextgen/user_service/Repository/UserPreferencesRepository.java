package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.UserPreferences;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserPreferencesRepository extends CassandraRepository<UserPreferences, Long> {

}
