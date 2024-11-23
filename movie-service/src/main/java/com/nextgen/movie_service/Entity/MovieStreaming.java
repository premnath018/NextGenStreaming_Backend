package com.nextgen.movie_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieStreaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @Column(name = "stream_url" , nullable = false)
    private String streamUrl;

    @Column(name = "resolution" , nullable = false)
    private String resolution;

}
