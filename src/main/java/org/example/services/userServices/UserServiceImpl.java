package org.example.services.userServices;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.InvalidInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl{
    @Autowired
    private UserRepository userRepository;


    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        var userOptional = userRepository.findByEmailAddress(userRegistrationRequest.getEmailAddress());
        if (userOptional.isPresent()) {
            throw new InvalidInput("Email address already in use");
        }
        User user = new User();

        user.setUserName(userRegistrationRequest.getUserName());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setEmailAddress(userRegistrationRequest.getEmailAddress());
        User savedUser = userRepository.save(user);

        return new UserRegistrationResponse(
                savedUser.getId(), savedUser.getUserName(),"has registered successfully"
            );
    }

    public UserLoginResponse loginUser(String emailAddress, String password) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        var userOptional = userRepository.findByEmailAddress(emailAddress);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getEmailAddress().equals(emailAddress)) {
                if (user.getPassword().equals(password))
                    userLoginResponse.setId(user.getId());
                userLoginResponse.setUserName(user.getUserName());
                         userLoginResponse.setMessage("is logged in successfully");
            }
        }else{
            throw new InvalidInput("Invalid email address");
        }
        return userLoginResponse;


//
//        try {
//            validateEmail(emailAddress);
//        } catch (InvalidInput e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        try {
//            validatePassword(password);
//        } catch (InvalidInput e) {
//            System.out.println("Error: " + e.getMessage());
//        }



    }
    public void validateEmail(String emailAddress){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        if(emailAddress.isEmpty() || !emailAddress.equals(userRegistrationRequest)) throw new InvalidInput(emailAddress);
    }
    public void validatePassword(String password){
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        if (password.isEmpty() || !password.equals(userRegistrationRequest))throw new InvalidInput(password);
    }




}


