package com.nextgen.movie_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name" , nullable = false)
    private String name;

    @Column(name = "image_url" , nullable = true)
    private String photoUrl;

    @Column(name = "actor_description" , nullable = true)
    private String description;
    @CreationTimestamp

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at" ,nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at"  ,nullable = false)
    private Date updatedAt;


}
