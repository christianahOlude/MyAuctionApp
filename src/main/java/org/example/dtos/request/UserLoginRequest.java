package org.example.dtos.request;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    private String emailAddress;
    private String password;
}
