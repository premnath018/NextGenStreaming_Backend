package com.nextgen.auth_service.Service;


import com.nextgen.auth_service.Model.UserCredential;
import com.nextgen.auth_service.Repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private UserCredentialRepository repository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    @Autowired
    public void setRepository(UserCredentialRepository repository) {
        this.repository = repository;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) { this.passwordEncoder = passwordEncoder; }
    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public boolean saveUser(UserCredential credential) {


        if (userExistsByUsername(credential.getUsername()) || userExistsByEmail(credential.getEmail()))  {
            return false;
        }

        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        credential.setRole("USER");
        UserCredential savedUser = repository.save(credential);

        return true;
    }

    public void updateLastLogin(String username) {
        Optional<UserCredential> userOptional = repository.findByUsername(username);
        if (userOptional.isPresent()) {
            UserCredential user = userOptional.get();
            user.setLastLogin(new Timestamp(System.currentTimeMillis()));
            repository.save(user);
        }
    }

    public String generateResetToken(String email) {
        Optional<UserCredential> userOptional = repository.findByEmail(email);

        if (userOptional.isPresent()) {
            UserCredential user = userOptional.get();
            String resetToken = UUID.randomUUID().toString();  // Generate unique token
            user.setResetToken(resetToken);
            user.setResetTokenGeneratedAt(new Timestamp(System.currentTimeMillis()));
            repository.save(user);

            return resetToken;  // Return the token as a response
        } else {
            return null;  // Email not found
        }
    }

    public boolean resetPassword(String token, String newPassword) {
        Optional<UserCredential> userOptional = repository.findByResetToken(token);

        if (userOptional.isPresent()) {
            UserCredential user = userOptional.get();

            long tokenExpiryTime = 600 * 1000; // 10 mins in milliseconds
            long currentTime = System.currentTimeMillis();
            if (currentTime - user.getResetTokenGeneratedAt().getTime() > tokenExpiryTime) {
                return false;  // Token expired
            }

            user.setPassword(passwordEncoder.encode(newPassword));
            user.setResetToken(null);  // Clear the reset token
            user.setResetTokenGeneratedAt(null);
            repository.save(user);
            return true;
        } else {
            return false;
        }
    }


    public String generateToken(String Username){
        return jwtService.generateToken(Username);
    }

    public boolean userExistsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public boolean userExistsByEmail(String email) {
        return repository.existsByEmail(email);
    }


}
