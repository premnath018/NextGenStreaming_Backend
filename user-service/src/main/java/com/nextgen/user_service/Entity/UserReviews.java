package com.nextgen.user_service.Entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table("user_reviews")
public class UserReviews implements Serializable {

    @PrimaryKey
    private ReviewKey id;        // Composite key (movie_id, user_id)

    private BigDecimal rating;   // Rating as decimal
    private String review;       // Review content
    private LocalDateTime reviewTime; // Time of review
}

