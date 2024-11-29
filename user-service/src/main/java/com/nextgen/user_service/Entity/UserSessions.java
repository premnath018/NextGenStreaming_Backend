package com.nextgen.user_service.Entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("user_sessions")
public class UserSessions implements Serializable {

    @PrimaryKey
    private SessionKey id;        // Composite key (user_id, session_id)

    private LocalDateTime loginTime;  // Login time
    private LocalDateTime logoutTime; // Logout time
    private String deviceDetails;    // Device details
}

