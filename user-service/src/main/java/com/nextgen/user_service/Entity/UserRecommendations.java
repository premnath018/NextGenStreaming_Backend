package com.nextgen.user_service.Entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table("user_recommendations")
public class UserRecommendations implements Serializable {

    @PrimaryKey
    private RecommendationKey id; // Composite key (user_id, recommended_at)

    private Long movieId;         // Recommended movie ID
    private Long genreId;         // Genre ID from PostgreSQL
    private Long languageId;      // Language ID from PostgreSQL
}

