package org.example.services.userServices;

import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.InvalidInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userServiceImpl;


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

//    @Test
//    void test_registeUser(){
//        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
//        userRegistrationRequest.setUserName("praise");
//        userRegistrationRequest.setPassword("praises");
//        userRegistrationRequest.setEmailAddress("email@email.com");
//        assertNotNull(userRegistrationRequest);
//
//        assertThrows(InvalidInput.class , () ->{
//            userServiceImpl.registerUser(userRegistrationRequest);
//        });
//    }
    @Test
    void loginUser(){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("names");
        userRegistrationRequest.setPassword("pass");
        userRegistrationRequest.setEmailAddress("olude1@email.com");
        assertNotNull(userRegistrationRequest);

        UserRegistrationResponse userRegistrationResponse = userServiceImpl.registerUser(userRegistrationRequest);
        assertNotNull(userRegistrationResponse);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmailAddress("olude1@email.com");
        userLoginRequest.setPassword("pass");
        assertNotNull(userLoginRequest);
        assertNotNull(userLoginRequest.getEmailAddress());
        assertNotNull(userLoginRequest.getPassword());

        UserLoginResponse userLoginResponse =
                userServiceImpl.loginUser("olude1@email.com","pass");
        assertNotNull(userLoginResponse);

        System.out.println("User Login Response:");
        System.out.println("ID: " + userLoginResponse.getId());
        System.out.println("Username: " + userLoginResponse.getUserName());
        System.out.println("Message: " + userLoginResponse.getMessage());

        assertNotNull(userLoginResponse.getId());
        assertEquals("names", userLoginResponse.getUserName());
        assertEquals("is logged in successfully", userLoginResponse.getMessage());
    }

    @Test
    void registerItem(){

    }
}