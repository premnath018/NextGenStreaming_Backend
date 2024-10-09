package com.nextgen.auth_service.Controller;


import com.nextgen.auth_service.DTO.ApiResponse;
import com.nextgen.auth_service.DTO.AuthRequest;
import com.nextgen.auth_service.Model.UserCredential;
import com.nextgen.auth_service.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserCredential credential) {
        authService.saveUser(credential);
        ApiResponse response = new ApiResponse(true, "User registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> getToken(@Valid @RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        if (authenticate.isAuthenticated()) {
            String token = authService.generateToken(authRequest.getUsername());
            authService.updateLastLogin(authRequest.getUsername());
            ApiResponse response = new ApiResponse(true, "Authentication successful", token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ApiResponse response = new ApiResponse(false, "Invalid Username or Password");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse> forgotPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String resetToken = authService.generateResetToken(email);

        if (resetToken != null) {
            return ResponseEntity.ok(new ApiResponse(true, "Password reset token generated", resetToken));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, "Email not found."));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse> resetPassword(@RequestBody Map<String, String> requestBody) {
        String token = requestBody.get("token");
        String newPassword = requestBody.get("newPassword");

        boolean passwordReset = authService.resetPassword(token, newPassword);

        if (passwordReset) {
            return ResponseEntity.ok(new ApiResponse(true, "Password reset successful."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "Invalid or expired reset token."));
        }
    }



    @GetMapping("/check-username/{username}")
    public ResponseEntity<ApiResponse> checkUsername(@PathVariable String username) {
        boolean exists = authService.userExistsByUsername(username);
        String message = exists ? "Username already exists." : "Username is available.";
        ApiResponse response = new ApiResponse(!exists, message);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-email/{email}")
    public ResponseEntity<ApiResponse> checkEmail(@PathVariable String email) {
        boolean exists = authService.userExistsByEmail(email);
        String message = exists ? "Email already exists." : "Email is available.";
        ApiResponse response = new ApiResponse(!exists, message);
        return ResponseEntity.ok(response);
    }

}
