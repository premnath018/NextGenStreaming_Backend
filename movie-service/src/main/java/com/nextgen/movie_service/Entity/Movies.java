package com.nextgen.movie_service.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies") // Table name in PostgreSQL
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Title field
    @NotBlank(message = "Title is mandatory") // Ensures title is not blank
    @Column(nullable = false, name = "title") // Maps to the 'title' column
    private String title;

    // Description field
    @NotBlank(message = "Description is mandatory") // Ensures description is not blank
    @Column(name = "description", length = 1000) // Maps to the 'description' column with a length limit
    private String description;

    // Release Date field
    @NotBlank(message = "Release date is mandatory") // Ensures release date is not blank
    @Column(name = "release_date") // Maps to the 'release_date' column
    private String releaseDate;

    // Duration field
    @NotBlank(message = "Duration is mandatory") // Ensures duration is not blank
    @Column(name = "duration") // Maps to the 'duration' column
    private String duration;

    // Rating field
    @Column(name = "rating" , nullable = true) // Maps to the 'rating' column
    private float rating;

    // Filepath field
    @NotBlank(message = "File path is mandatory") // Ensures file path is not blank
    @Column(name = "filepath") // Maps to the 'filepath' column
    private String filepath;

    // Poster URL field
    @NotBlank(message = "Poster URL is mandatory") // Ensures poster URL is not blank
    @Column(name = "poster_url") // Maps to the 'poster_url' column
    private String posterUrl;

    // Background URL field
    @NotBlank(message = "Background URL is mandatory") // Ensures background URL is not blank
    @Column(name = "background_url") // Maps to the 'background_url' column
    private String backgroundUrl;

    // Trailer URL field
    @NotBlank(message = "Trailer URL is mandatory") // Ensures trailer URL is not blank
    @Column(name = "trailer_url") // Maps to the 'trailer_url' column
    private String trailerUrl;

    // Created at timestamp
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, name = "created_at") // Maps to the 'created_at' column
    private Date createdAt;

    // Updated at timestamp
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "updated_at") // Maps to the 'updated_at' column
    private Date updatedAt;



}
