package com.nextgen.auth_service.service;


import com.nextgen.auth_service.entity.UserCredential;
import com.nextgen.auth_service.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;


    public String saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        return "USER ADDED";
    }
    public String generateToken(String Username){
        return jwtService.generateToken(Username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
