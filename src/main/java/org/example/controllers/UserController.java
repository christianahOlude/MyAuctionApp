package org.example.controllers;

import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return new ResponseEntity<>(userService.registerUser(userRegistrationRequest), HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        return new ResponseEntity<>(userService.loginUser(userLoginRequest), HttpStatus.OK);

    }

}
