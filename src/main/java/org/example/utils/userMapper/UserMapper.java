package org.example.utils.userMapper;

import org.example.data.models.User;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;

public class UserMapper {

    public static User mapUserToRegisterRequest(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUserName(userRegistrationRequest.getUserName());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setEmailAddress(userRegistrationRequest.getEmailAddress());
        return user;
    }

    public static UserRegistrationResponse mapRegisterToResponse(User newUser) {
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setMessage("Registration Successful");
        userRegistrationResponse.setData(newUser.getEmailAddress());
        userRegistrationResponse.setUserId(newUser.getId());
        return userRegistrationResponse;
    }

    public static UserLoginResponse mapLoginRequestToResponse(User user) {
        UserLoginResponse loginResponse = new UserLoginResponse();
        loginResponse.setMessage("Login Successful");
        loginResponse.setUserId(user.getId());
        loginResponse.setData(user.getEmailAddress());
        return loginResponse;
    }


}
