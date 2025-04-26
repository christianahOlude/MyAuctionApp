package org.example.services.userServices;

import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
    UserLoginResponse loginUser(UserLoginRequest userLoginRequest);
}
