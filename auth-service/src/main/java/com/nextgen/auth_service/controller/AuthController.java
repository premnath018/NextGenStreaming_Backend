package com.nextgen.auth_service.controller;


import com.nextgen.auth_service.dto.AuthRequest;
import com.nextgen.auth_service.entity.UserCredential;
import com.nextgen.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> addNewUser(@RequestBody UserCredential user){
        System.out.println(user);
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        }else {
            throw new RuntimeException("Invalid Username & password");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        service.validateToken(token);
        return "Token is valid";
    }
}
