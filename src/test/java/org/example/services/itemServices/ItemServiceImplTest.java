package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.data.models.User;
import org.example.data.repositories.ItemRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @Autowired
    private ItemRepository itemRepository;

//    public ItemRegistrationRequest setItemRegistration(){
//        //
//    }
//    @Autowired
//    ItemRepository itemRepository;
    @Test
    public void registerItem() {
//        User user = new User();
//       ItemRegistrationResponse itemRegistrationResponse = new ItemRegistrationResponse();
//        ItemRegistrationRequest itemRegistrationRequest = new ItemRegistrationRequest();
//        itemRegistrationRequest.setId("7878");
//        itemRegistrationRequest.setTitle("Toyota");
//        itemRegistrationRequest.setDescription("2013 model");
//        itemRegistrationRequest.setAuctionOwner(user);
//        itemRegistrationRequest.setStartingBid(1000000.00);
//        itemRegistrationRequest.setAuctionStartDate(LocalDateTime.now());
//        itemRegistrationRequest.setAuctionStartTime(LocalDateTime.now());
//        itemRegistrationRequest.setAuctionEndTime(LocalDateTime.now());
//
//        ItemRegistrationResponse itemRegistrationResponse = itemServiceImpl.registerItem(itemRegistrationRequest);
//        assertEquals("Toyota", itemRegistrationResponse.getTitle());
////        assertEquals("");
    }
}