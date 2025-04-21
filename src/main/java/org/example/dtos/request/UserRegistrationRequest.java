package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class UserRegistrationRequest {
    private String userName;
    private String password;
    @Indexed(unique = true)
    private String emailAddress;
}
