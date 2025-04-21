package org.example.services.userServices;

import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserRegistrationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;


    @Test
    void registerUser() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("name");
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setEmailAddress("email@email.com");
        assertNotNull(userRegistrationRequest);

        UserRegistrationResponse userRegistrationResponse = userServiceImpl.registerUser(userRegistrationRequest);
        assertNotNull(userRegistrationResponse);

        System.out.println("User Registration Response:");
        System.out.println("ID: " + userRegistrationResponse.getId());
        System.out.println("Username: " + userRegistrationResponse.getUserName());
        System.out.println("Message: " + userRegistrationResponse.getMessage());

        assertNotNull(userRegistrationResponse.getId());
        assertEquals("name", userRegistrationResponse.getUserName());
        assertEquals("has registered successfully", userRegistrationResponse.getMessage());
    }

    @Test
    void loginUser(){
        UserLoginRequest.getUserName();
        UserLoginRequest.get
    }
}