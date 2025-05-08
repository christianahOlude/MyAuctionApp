package org.example.services.userServices;

import org.example.data.repositories.UserRepository;
import org.example.dtos.request.*;
import org.example.dtos.response.*;
import org.example.exceptions.EmailAlreadyExistException;
import org.example.exceptions.InvalidAmountException;
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


    public void setNewUser(UserRegistrationRequest userRegistrationRequest) {
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setUserName("christianah");
        userRegistrationRequest.setEmailAddress("christianah@gmail.com");
    }

    public void setUserLogin(UserLoginRequest userLoginRequest) {
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
    public void sellerCanSetNewItem() {
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
        itemRegistrationRequest.setStartingBid(1_000_000.00);

        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");
    }

    @Test
    public void sellerCanUpdateItem() {
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
        itemRegistrationRequest.setStartingBid(1_000_000.00);


        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");
        ;
        System.out.println(itemRegistrationResponse.getItemId());
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTitle("Toyota corolla");
        updateItemRequest.setDescription("Caro");
        updateItemRequest.setBiddingPrice(10_000_000.0);
        UpdateItemResponse updatedItemResponse = itemService.updateItem(itemRegistrationResponse.getItemId(), updateItemRequest);
        assertTrue(updatedItemResponse.isStatus());
        assertNotNull(updatedItemResponse.getItemId());
        System.out.print(itemRegistrationRequest);
        assertEquals("updated successfully", updatedItemResponse.getMessage());


    }

    @Test
    public void sellerCanGetItems() {
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
        itemRegistrationRequest.setStartingBid(1_000_000.00);

        itemRegistrationRequest.setTitle("Rolls Royce");
        itemRegistrationRequest.setDescription("Car");
        itemRegistrationRequest.setEmail("christy@gmail.com");
        itemRegistrationRequest.setAuctionStartDate(LocalDate.now());
        itemRegistrationRequest.setStartingBid(10_000_000.00);

        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");

        assertNotNull(itemService.getAllItems());
        System.out.println(itemService.getAllItems());
    }

    @Test
    public void sellerCanDeleteItems() {
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
        itemRegistrationRequest.setStartingBid(1_000_000.00);
        itemService.createItem(itemRegistrationRequest);

        ItemRegistrationRequest itemRegistrationRequest2 = new ItemRegistrationRequest();
        itemRegistrationRequest2.setTitle("Rolls Royce");
        itemRegistrationRequest2.setDescription("Car");
        itemRegistrationRequest2.setEmail("christy@gmail.com");
        itemRegistrationRequest2.setAuctionStartDate(LocalDate.now());
        itemRegistrationRequest2.setStartingBid(10_000_000.00);
        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest2);
        assertEquals(2, itemRepository.count());
        System.out.println(itemRegistrationResponse.getItemId());


        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setItemId(itemRegistrationResponse.getItemId());
        deleteItemRequest.setUserId(response.getUserId());
        itemService.deleteItem(deleteItemRequest);

        assertEquals(1, itemRepository.count());
        assertNotNull(itemService.getAllItems());
    }

    @Test
    public void throwExceptionForInvalidAmount(){
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
        itemRegistrationRequest.setStartingBid(1_000_000.00);
        itemService.createItem(itemRegistrationRequest);

        itemRegistrationRequest.setStartingBid(0);

        InvalidAmountException exception = assertThrows(InvalidAmountException.class, () -> {
            itemService.createItem(itemRegistrationRequest);
        });
        assertEquals("Amount can't be 0", exception.getMessage());
    }

}

