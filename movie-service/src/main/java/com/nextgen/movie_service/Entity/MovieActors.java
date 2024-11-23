package com.nextgen.movie_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieActors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id" , referencedColumnName = "id")
    Movies movies;

    @ManyToOne
    @JoinColumn(name = "actor_id" , referencedColumnName = "id")
    Actors actors;


}
