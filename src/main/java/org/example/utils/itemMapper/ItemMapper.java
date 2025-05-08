package org.example.utils.itemMapper;

import org.example.data.models.Item;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.PlaceBidRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.response.DeleteItemResponse;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.dtos.response.PlaceBidResponse;
import org.example.dtos.response.UpdateItemResponse;

public class ItemMapper {

    public static Item mapRequestToItem(ItemRegistrationRequest itemRegistrationRequest) {
        Item item = new Item();
        item.setId(itemRegistrationRequest.getId());
        item.setTitle(itemRegistrationRequest.getTitle());
        item.setDescription(itemRegistrationRequest.getDescription());
        item.setEmail(itemRegistrationRequest.getEmail());
        item.setStartingBid(itemRegistrationRequest.getStartingBid());
        item.setAvailable(true);
        return item;
    }

    public static ItemRegistrationResponse mapItemToResponse(Item item) {
        ItemRegistrationResponse itemRegistrationResponse = new ItemRegistrationResponse();
        itemRegistrationResponse.setMessage("Item Added Successfully");
        itemRegistrationResponse.setStatus(true);
        itemRegistrationResponse.setData(item.getTitle());
        itemRegistrationResponse.setItemId(item.getId());
        return itemRegistrationResponse;
    }

    public static Item mapUpdateItemRequestToItem(UpdateItemRequest updateItemRequest) {
        Item itemToUpdate = new Item();
        itemToUpdate.setTitle(updateItemRequest.getTitle());
        itemToUpdate.setDescription(updateItemRequest.getDescription());
        itemToUpdate.setStartingBid(updateItemRequest.getBiddingPrice());
        return itemToUpdate;
    }

    public static UpdateItemResponse mapUpdateItemToResponse(Item item) {
        UpdateItemResponse updateItemResponse = new UpdateItemResponse();
        updateItemResponse.setMessage("updated successfully");
        updateItemResponse.setItemId(item.getId());
        updateItemResponse.setStatus(true);
        return updateItemResponse;
    }
    public static DeleteItemResponse mapDeleteItemToResponse(Item item) {
        DeleteItemResponse deleteItemResponse = new DeleteItemResponse();
        deleteItemResponse.setId(item.getId());
        deleteItemResponse.setMessage("deleted successfully");
        return deleteItemResponse;
    }
//    public static PlaceBidResponse mapBiddedItemToResponse(PlaceBidRequest placeBidRequest){
//
//    }
}
