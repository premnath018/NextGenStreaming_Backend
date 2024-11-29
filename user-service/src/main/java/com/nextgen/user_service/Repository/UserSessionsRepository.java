package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.SessionKey;
import com.nextgen.user_service.Entity.UserSessions;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserSessionsRepository extends CassandraRepository<UserSessions, SessionKey> {

}
