package org.example.services.itemServices;


import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UserRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.services.userServices.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceImplTest {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void clearUserRepo() {
        userRepository.deleteAll();
    }
    @BeforeEach
    void clearItemRepo() {
        itemRepository.deleteAll();
    }





    @Test
    public void setNewItem() {
        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
        itemRegistrationRequest.setTitle("Toyota camry");
        itemRegistrationRequest.setDescription("Car");
        itemRegistrationRequest.setEmail("christ1@gmail.comchrist1@gmail.com");
        itemRegistrationRequest.setAuctionStartDate(LocalDate.now());
        itemRegistrationRequest.setAuctionStartTime(LocalTime.now());
        itemRegistrationRequest.setAuctionEndTime(LocalTime.now());
        itemRegistrationRequest.setBiddingPrice(1_000_000.00);

        ItemRegistrationResponse itemRegistrationResponse = itemService.createItem(itemRegistrationRequest);
        assertThat(itemRegistrationResponse.getMessage()).isEqualTo("Item Added Successfully");
    }

    public void setNewUserRegistration(UserRegistrationRequest userRegistrationRequest){
        userRegistrationRequest.setPassword("password");
        userRegistrationRequest.setUserName("christianah");
        userRegistrationRequest.setEmailAddress("christ1@gmail.com");
    }


//    @Test
//    public void registerItem() {
//        UserRegistrationRequest newUser = new UserRegistrationRequest();
//        setNewUserRegistration(newUser);
//        UserRegistrationResponse response = userService.registerUser(newUser);
//        System.out.println("userResponse: " + response.getUserId());
//        assertEquals("Registration Successful", response.getMessage());
//
//        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
//        setNewItem(response.getUserId(), itemRegistrationRequest);
//        ItemRegistrationResponse itemResponse = itemService.registerItem(itemRegistrationRequest);
//        String expectedItemTitle = itemRegistrationRequest.getTitle();
//        assertEquals(expectedItemTitle, itemResponse.getData());
//        assertTrue(itemResponse.isStatus());
//        assertEquals("Item Added Successfully", itemResponse.getMessage());
//    }
//    @Test
//    public void getAllItems(){
//
//        UserRegistrationRequest newUser = new UserRegistrationRequest();
//        setNewUserRegistration(newUser);
//        UserRegistrationResponse response = userService.registerUser(newUser);
//        System.out.println("userResponse: " + response.getUserId());
//        assertEquals("Registration Successful", response.getMessage());
//
//        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
//        setNewItem(response.getUserId(), itemRegistrationRequest);
//        ItemRegistrationResponse itemResponse = itemService.registerItem(itemRegistrationRequest);
//        String expectedItemTitle = itemRegistrationRequest.getTitle();
//        assertEquals(expectedItemTitle, itemResponse.getData());
//        assertTrue(itemResponse.isStatus());
//        assertEquals("Item Added Successfully", itemResponse.getMessage());
//
//        List<Item> expected = itemService.getAllItems();
//        assertNotNull(expected.isEmpty());
//        System.out.println("Expected items: " + expected);
//
//    }
//    @Test
//    public void updateItem(){
//        UserRegistrationRequest newUser = new UserRegistrationRequest();
//        setNewUserRegistration(newUser);
//        UserRegistrationResponse response = userService.registerUser(newUser);
//        System.out.println("userResponse: " + response.getUserId());
//        assertEquals("Registration Successful", response.getMessage());
//
//        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
//        setNewItem(response.getUserId(), itemRegistrationRequest);
//        ItemRegistrationResponse itemResponse = itemService.registerItem(itemRegistrationRequest);
//        String expectedItemTitle = itemRegistrationRequest.getTitle();
//        assertEquals(expectedItemTitle, itemResponse.getData());
//        assertTrue(itemResponse.isStatus());
//        assertEquals("Item Added Successfully", itemResponse.getMessage());
//
//        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
//        itemService.registerItem(itemRegistrationRequest);
//        itemRegistrationRequest.setId(updateItemRequest.getId());
//        itemRegistrationRequest.setTitle(updateItemRequest.getTitle());
//        itemRegistrationRequest.setDescription(updateItemRequest.getDescription());
//        itemRegistrationRequest.setBiddingPrice(updateItemRequest.getBiddingPrice());
//        UpdateItemResponse updateItemResponse = itemService.updateItem(updateItemRequest);
////        Item item = itemService.findById(updateItemResponse.getId());
//        String expectedItemId = updateItemRequest.getId();
//        assertEquals(expectedItemId, updateItemResponse.getId());
//        assertEquals("Toyota corolla", updateItemResponse.getItem());
//    }

}