package org.example.dtos.response;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserRegistrationResponse {
    private String userId;
    private Object data;
    private String message;
}
