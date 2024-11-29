package com.nextgen.user_service.Entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table("user_wishlist")
public class UserWishlist implements Serializable {

    @PrimaryKey
    private WishlistKey id;     // Composite key (user_id, movie_id)

    private Long genreId;       // Genre ID from PostgreSQL
    private Long languageId;    // Language ID from PostgreSQL
    private LocalDateTime addedAt; // Time added to wishlist
}

