package org.example.services.userServices;

import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.EmailAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
        private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void setNewUser(UserRegistrationRequest userRegistrationRequest){
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setUserName("christianah");
        userRegistrationRequest.setEmailAddress("christianah@gmail.com");

    }

    @Test
    void registerUser() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(expected, response.getData());
        assertEquals("Registration Successful", response.getMessage());
    }

   @Test
    void testInvalidPassword(){
       UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
       setNewUser(userRegistrationRequest);
       UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
       String expected = userRegistrationRequest.getEmailAddress();
       assertEquals(expected, response.getData());
       assertEquals("Registration Successful", response.getMessage());

       assertThrows(EmailAlreadyExistException.class, () -> userService.registerUser(userRegistrationRequest));
    }

//    @Test
//    void testInvalidEmail(){
//        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
//        userRegistrationRequest.setUserName("names");
//        userRegistrationRequest.setPassword("password");
//        userRegistrationRequest.setEmailAddress(" ");
//        assertNotNull(userRegistrationRequest);
//
//        assertThrows(InvalidInput.class , () ->{
//            userServiceImpl.registerUser(userRegistrationRequest);
//        });
//    }
//    @Test
//    void loginUser(){
//        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
//        userRegistrationRequest.setUserName("names");
//        userRegistrationRequest.setPassword("pass");
//        userRegistrationRequest.setEmailAddress("oludechristianah16@email.com");
//        assertNotNull(userRegistrationRequest);
//
//        UserRegistrationResponse userRegistrationResponse = userServiceImpl.registerUser(userRegistrationRequest);
//        assertNotNull(userRegistrationResponse);
//
//        UserLoginRequest userLoginRequest = new UserLoginRequest();
//        userLoginRequest.setEmailAddress("oludechristianah16@email.com");
//        userLoginRequest.setPassword("pass");
//        assertNotNull(userLoginRequest);
//        assertNotNull(userLoginRequest.getEmailAddress());
//        assertNotNull(userLoginRequest.getPassword());
//
//        UserLoginResponse userLoginResponse =
//                userServiceImpl.loginUser("oludechristianah16@email.com","pass");
//        assertNotNull(userLoginResponse);
//
//        assertEquals("names", userLoginResponse.getUserName());
//        assertEquals("is logged in successfully", userLoginResponse.getMessage());
//    }
}