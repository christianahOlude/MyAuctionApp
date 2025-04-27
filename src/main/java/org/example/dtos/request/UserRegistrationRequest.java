package org.example.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserRegistrationRequest {
//    private String id;
    private String userName;
    private String password;
    private String emailAddress;
}
