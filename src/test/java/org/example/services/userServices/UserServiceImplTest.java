package org.example.services.userServices;

import org.example.data.models.Item;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.request.UserLoginRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.dtos.response.UpdateItemResponse;
import org.example.dtos.response.UserLoginResponse;
import org.example.dtos.response.UserRegistrationResponse;
import org.example.exceptions.EmailAlreadyExistException;
import org.example.services.itemServices.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.data.repositories.ItemRepository;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @BeforeEach
    void clearItemRepo() {
        itemRepository.deleteAll();
    }


    public void setNewUser(UserRegistrationRequest userRegistrationRequest){
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setUserName("christianah");
        userRegistrationRequest.setEmailAddress("christianah@gmail.com");
    }

     public void setUserLogin(UserLoginRequest userLoginRequest){
        userLoginRequest.setEmailAddress("christianah@gmail.com");
        userLoginRequest.setPassword("password");
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
    void testThatYouCantRegisterTwice() {
       UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
       setNewUser(userRegistrationRequest);
       UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
       String expected = userRegistrationRequest.getEmailAddress();
       assertEquals(expected, response.getData());
       assertEquals("Registration Successful", response.getMessage());

       assertThrows(EmailAlreadyExistException.class, () -> userService.registerUser(userRegistrationRequest));
    }

    @Test
    public void testThatUserCanLogin() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        setNewUser(userRegistrationRequest);
        UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(1, userRepository.count());
        assertEquals(expected, response.getData());
        assertEquals("Registration Successful", response.getMessage());
        System.out.println(userRegistrationRequest);

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        setUserLogin(userLoginRequest);
        UserLoginResponse loginResponse = userService.loginUser(userLoginRequest);
        assertEquals("Login Successful", loginResponse.getMessage());
        assertEquals(userLoginRequest.getEmailAddress(), loginResponse.getData());
    }

    @Test
    public void setNewItem() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Christy");
        userRegistrationRequest.setPassword("Password");
        userRegistrationRequest.setEmailAddress("christy@gmail.com");
        UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(expected, response.getData());
        assertEquals("Registration Successful", response.getMessage());

        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
        itemRegistrationRequest.setTitle("Toyota camry");
        itemRegistrationRequest.setDescription("Car");
        itemRegistrationRequest.setEmail("christy@gmail.com");
        itemRegistrationRequest.setAuctionStartDate(LocalDate.now());
        itemRegistrationRequest.setAuctionStartTime(LocalTime.now());
        itemRegistrationRequest.setAuctionEndTime(LocalTime.now());
        itemRegistrationRequest.setBiddingPrice(1_000_000.00);

        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");
    }

    @Test
    public void userCanUpdateItem() {
        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUserName("Christy");
        userRegistrationRequest.setPassword("Password");
        userRegistrationRequest.setEmailAddress("christy@gmail.com");
        UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
        String expected = userRegistrationRequest.getEmailAddress();
        assertEquals(expected, response.getData());
        assertEquals("Registration Successful", response.getMessage());

        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
        itemRegistrationRequest.setTitle("Toyota camry");
        itemRegistrationRequest.setDescription("Car");
        itemRegistrationRequest.setEmail("christy@gmail.com");
        itemRegistrationRequest.setAuctionStartDate(LocalDate.now());
        itemRegistrationRequest.setAuctionStartTime(LocalTime.now());
        itemRegistrationRequest.setAuctionEndTime(LocalTime.now());
        itemRegistrationRequest.setBiddingPrice(1_000_000.00);

        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");

        UpdateItemRequest updateItemRequest = itemService.findItemByTitle("Toyota corolla");
        updateItemRequest.setTitle("Toyota corolla");
        updateItemRequest.setDescription("Caro");
        updateItemRequest.setBiddingPrice(10_000_000.00);
        UpdateItemResponse updatedItemResponse = itemService.updateItem(updateItemRequest);
        assertNotNull(updatedItemResponse.getItem());
        System.out.print(updatedItemResponse.getItem());

    }


}