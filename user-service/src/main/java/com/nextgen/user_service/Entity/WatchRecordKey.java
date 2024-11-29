package com.nextgen.user_service.Entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@PrimaryKeyClass
public class WatchRecordKey implements Serializable {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId; // Partition key: Groups records by user

    @PrimaryKeyColumn(name = "movie_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Long movieId; // Clustering key: Sorts by movie within a user's partition

    @PrimaryKeyColumn(name = "watch_date", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private LocalDate watchDate; // Clustering key: Sorts by watch date within the movie's cluster

}
