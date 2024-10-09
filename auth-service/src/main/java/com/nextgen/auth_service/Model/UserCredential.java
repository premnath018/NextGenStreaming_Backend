package com.nextgen.auth_service.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile") // Table name in PostgreSQL
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Username field
    @NotBlank(message = "Username is mandatory") // Ensures username is not blank
    @Column(unique = true, nullable = false, name = "username") // Maps to the 'username' column
    private String username;

    // Name field
    @NotBlank(message = "Name is mandatory") // Ensures name is not blank
    @Column(name = "name") // Maps to the 'name' column
    private String name;

    // Email field
    @NotBlank(message = "Email is mandatory") // Ensures email is not blank
    @Email(message = "Email should be valid") // Validates email format
    @Column(unique = true, nullable = false, name = "email") // Maps to the 'email' column
    private String email;

    // Password field
    @NotBlank(message = "Password is mandatory") // Ensures password is not blank
    @Column(name = "password") // Maps to the 'password' column
    private String password;

    // Role field
    @Column(name = "role") // Maps to the 'role' column
    private String role;

    // Timestamps for created at and last login
    @CreationTimestamp
    @Column(name = "created_at" , updatable = false) // Maps to the 'created_at' column
    private LocalDateTime createdAt;

    @Column(name = "last_login") // Maps to the 'last_login' column
    private Timestamp lastLogin;

    // Reset token field
    @Column(name = "reset_token") // Maps to the 'reset_token' column
    private String resetToken;

    // Timestamp for when the reset token was generated
    @Column(name = "reset_token_generated_at") // Maps to the 'reset_token_generated_at' column
    private Timestamp resetTokenGeneratedAt;

}
