package com.nextgen.user_service.Entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table("user_watch_records")
public class UserWatchRecord  implements Serializable {

    @PrimaryKey
    private WatchRecordKey id;   // Composite key (user_id, movie_id, watch_date)

    private int progressPercent;    // Percentage watched
    private int watchDuration;      // Duration watched in seconds
    private String deviceType;      // Device used
    private LocalDateTime watchTimestamp; // Actual watch timestamp
}

