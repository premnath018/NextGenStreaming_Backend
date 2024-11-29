package com.nextgen.user_service.Entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@PrimaryKeyClass
public class RecommendationKey implements Serializable {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long userId; // Partition key: Groups recommendations by user

    @PrimaryKeyColumn(name = "recommended_at", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDateTime recommendedAt; // Clustering key: Orders recommendations by timestamp

}
