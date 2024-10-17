package com.nextgen.auth_service.DTO;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;
    private Map<String, String> errors;


    // Default constructor
    public ApiResponse() {}

    // Parameterized constructor without data (for error or simple responses)
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, Map<String, String> errors) {
        this.success = success;
        this.message = message;
        this.errors = errors;
    }

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    // Parameterized constructor with data (for success responses)
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "ApiResponseDTO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
