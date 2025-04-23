package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {
    private String emailAddress;
    private String password;
}
