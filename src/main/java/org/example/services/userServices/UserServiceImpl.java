package org.example.services.userServices;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.EmailCantBeNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUserName(userRegistrationRequest.getUserName());
        user.setPassword(userRegistrationRequest.getPassword());
        user.setEmailAddress(userRegistrationRequest.getEmailAddress());
        User savedUser = userRepository.save(user);

        return new UserRegistrationResponse(
                savedUser.getId(), savedUser.getUserName(),"has registered successfully"
            );
    }
    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest){
        String emailAddress = userLoginRequest.getEmailAddress();
        String password = userLoginRequest.getPassword();

        boolean isValidUser = authenticateUser(emailAddress, password);

    }

    public String authenticateUser(String emailAddress, String password) {
        UserRegistrationResponse userRegistrationResponse;
        if(emailAddress.isEmpty()){
            throw new EmailCantBeNull(emailAddress);
        }else if{
            emailAddress !equals(userRegistrationResponse)
        }
        return "login successfully";
    }
}


