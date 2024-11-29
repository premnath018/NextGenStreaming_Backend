package com.nextgen.user_service.Repository;

import com.nextgen.user_service.Entity.UserWatchRecord;
import com.nextgen.user_service.Entity.WatchRecordKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserWatchRecordRepository extends CassandraRepository<UserWatchRecord, WatchRecordKey> {

}