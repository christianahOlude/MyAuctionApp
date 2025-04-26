package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.data.models.User;
import org.example.data.repositories.ItemRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.exceptions.ItemNotFoundException;
import org.example.utils.itemMapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public ItemRegistrationResponse registerItem(ItemRegistrationRequest itemRegistrationRequest) {

        boolean isFound = itemRepository.findItemByTitle(itemRegistrationRequest.getTitle());
        if (!isFound) {
            Item newItem = ItemMapper.mapRequestToItem(itemRegistrationRequest);
            itemRepository.save(newItem);
            return ItemMapper.mapItemToResponse(newItem);

        }
        return null;
    }


}
