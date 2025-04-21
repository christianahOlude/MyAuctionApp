package org.example.services.userServices;

import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserRegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
}
