package com.nextgen.auth_service.DTO;

import lombok.*;

@Builder
@Getter
@Setter
public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    // Default constructor
    public ApiResponse() {}

    // Parameterized constructor without data (for error or simple responses)
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
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
