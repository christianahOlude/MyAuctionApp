package org.example.utils.itemMapper;

import org.example.data.models.Item;
import org.example.data.repositories.ItemRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

public class ItemMapper {

    public static Item mapRequestToItem(ItemRegistrationRequest itemRegistrationRequest){
        Item item = new Item();
        item.setId(itemRegistrationRequest.getId());
        item.setTitle(itemRegistrationRequest.getTitle());
        item.setDescription(itemRegistrationRequest.getDescription());
        item.setEmail(itemRegistrationRequest.getEmail());
        item.setBiddingPrice(itemRegistrationRequest.getBiddingPrice());
        item.setAuctionEndTime(LocalTime.MIDNIGHT);
        item.setAuctionStartTime(LocalTime.NOON);
        item.setAvailable(true);
        return item;
    }

    public static ItemRegistrationResponse mapItemToResponse(Item item){
        ItemRegistrationResponse itemRegistrationResponse = new ItemRegistrationResponse();
        itemRegistrationResponse.setMessage("Item Added Successfully");
        itemRegistrationResponse.setStatus(true);
        itemRegistrationResponse.setData(item.getTitle());
        return itemRegistrationResponse;
    }
//    public static Item mapUpdateItemRequestToItem(UpdateItemRequest updateItemRequest){
//        Item itemToUpdate = new Item();
//        itemToUpdate.setTitle(updateItemRequest.getTitle());
//        itemToUpdate.setDescription(updateItemRequest.getDescription());
//        itemToUpdate.setBiddingPrice(updateItemRequest.getBiddingPrice());
//        return itemToUpdate;
//    }

}
