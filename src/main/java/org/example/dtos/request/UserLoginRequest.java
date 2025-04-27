package org.example.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserLoginRequest {
    private String emailAddress;
    private String password;
}
