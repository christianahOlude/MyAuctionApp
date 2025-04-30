package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.dtos.request.DeleteItemRequest;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.dtos.response.UpdateItemResponse;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface ItemService {

    ItemRegistrationResponse createItem(ItemRegistrationRequest itemRegistrationRequest);
    List<Item> getAllItems();
    UpdateItemResponse updateItem(String itemId, UpdateItemRequest updateItemRequest);
    void deleteItem(DeleteItemRequest deleteItemRequest);
}
