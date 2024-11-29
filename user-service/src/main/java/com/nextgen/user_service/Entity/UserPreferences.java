package com.nextgen.user_service.Entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Table("user_preferences")
public class UserPreferences implements Serializable {

    @PrimaryKey
    private Long userId;          // User ID from PostgreSQL

    private Long genreId;         // Genre ID from PostgreSQL
    private Long languageId;      // Language ID from PostgreSQL
    private String favoriteActor; // Favorite actor
}
