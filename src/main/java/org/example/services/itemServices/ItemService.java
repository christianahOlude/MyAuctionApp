package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.data.repositories.ItemRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;

public interface ItemService {
    ItemRegistrationResponse registerItem(ItemRegistrationRequest itemRegistrationRequest);
}
