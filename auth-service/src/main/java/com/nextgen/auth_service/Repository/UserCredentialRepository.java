package com.nextgen.auth_service.Repository;

import com.nextgen.auth_service.Model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<UserCredential> findByEmail(String email);

    Optional<UserCredential> findByResetToken(String resetToken);

}
