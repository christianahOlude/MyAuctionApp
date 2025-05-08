package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.data.models.User;
import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.DeleteItemRequest;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.dtos.response.UpdateItemResponse;
import org.example.exceptions.InvalidAmountException;
import org.example.exceptions.ItemNotFoundException;
import org.example.exceptions.UserNotFoundException;
import org.example.utils.itemMapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;




    @Override
    public ItemRegistrationResponse createItem(ItemRegistrationRequest itemRegistrationRequest) {
        User foundUser = userRepository.findByEmailAddress(itemRegistrationRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found, kindly register"));

        Item newItem = ItemMapper.mapRequestToItem(itemRegistrationRequest);
        if(newItem.getStartingBid() == 0) {
            throw new InvalidAmountException("Amount can't be 0");
        }
        itemRepository.save(newItem);
        foundUser.getItems().add(newItem);
        userRepository.save(foundUser);
        return ItemMapper.mapItemToResponse(newItem);
    }


    @Override
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public UpdateItemResponse updateItem(String itemId, UpdateItemRequest updateItemRequest) {
        Item foundItem = itemRepository.findItemById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));

        foundItem.setTitle(updateItemRequest.getTitle());
        foundItem.setDescription(updateItemRequest.getDescription());
        foundItem.setStartingBid(updateItemRequest.getBiddingPrice());
        itemRepository.save(foundItem);
        return ItemMapper.mapUpdateItemToResponse(foundItem);
    }

    @Override
    public void deleteItem(DeleteItemRequest deleteItemRequest) {
        User foundUser = userRepository.findUserById(deleteItemRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found, kindly register"));

        Item itemToBeDeleted = itemRepository.findItemById(deleteItemRequest.getItemId())
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));

        itemRepository.delete(itemToBeDeleted);

        foundUser.getItems().remove(itemToBeDeleted);
        userRepository.save(foundUser);

        ItemMapper.mapDeleteItemToResponse(itemToBeDeleted);
    }

}
