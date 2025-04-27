package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.request.UpdateItemRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.dtos.response.UpdateItemResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public interface ItemService {

    ItemRegistrationResponse createItem(ItemRegistrationRequest itemRegistrationRequest);

    List<Item> getAllItems();
    UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest);
    UpdateItemRequest findItemByTitle(String title);
    Item findById(String id);

//    UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest);
}
