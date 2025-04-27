package org.example.services.userServices;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.EmailAlreadyExistException;
import org.example.exceptions.EmailNotFoundException;
import org.example.exceptions.IncorrestPasswordException;
import org.example.exceptions.InvalidInput;
import org.example.utils.userMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        boolean isEmailExist = userRepository.existsUserByEmailAddress(userRegistrationRequest.getEmailAddress());
        if (isEmailExist) {
            throw new EmailAlreadyExistException(userRegistrationRequest.getEmailAddress() + "already exist");
        }

        User newUser = UserMapper.mapUserToRegisterRequest(userRegistrationRequest);
        userRepository.save(newUser);
        return UserMapper.mapRegisterToResponse(newUser);
    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest userLoginRequest) {
        User foundUser = userRepository.findByEmailAddress(userLoginRequest.getEmailAddress())
                .orElseThrow(() -> new EmailNotFoundException("Email address not found"));

        boolean correctPassword = foundUser.getPassword().equals(userLoginRequest.getPassword());
        if (!correctPassword) {
            throw new IncorrestPasswordException("Incorrect password");
        }
        return UserMapper.mapLoginRequestToResponse(foundUser);
    }
}