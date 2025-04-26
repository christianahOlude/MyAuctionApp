package org.example.utils.itemMapper;

import org.example.data.models.Item;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;

public class ItemMapper {

    public static Item mapRequestToItem(ItemRegistrationRequest itemRegistrationRequest){
        Item item = new Item();
        item.setId(itemRegistrationRequest.getId());
        item.setTitle(itemRegistrationRequest.getTitle());
        item.setDescription(itemRegistrationRequest.getDescription());
        item.setAuctionOwner(itemRegistrationRequest.getAuctionOwner());
        item.setAuctionEndTime(itemRegistrationRequest.getAuctionEndTime());
        item.setAuctionStartTime(itemRegistrationRequest.getAuctionStartTime());
        return item;
    }

    public static ItemRegistrationResponse mapItemToResponse(Item item){
        ItemRegistrationResponse itemRegistrationResponse = new ItemRegistrationResponse();
        itemRegistrationResponse.setMessage("Item Added Successfully");
        itemRegistrationResponse.setStatus(true);
        itemRegistrationResponse.setData(item);
        return itemRegistrationResponse;
    }
}
