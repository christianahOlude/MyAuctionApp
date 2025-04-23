package org.example.services.itemServices;

import org.example.data.models.Item;
import org.example.data.repositories.ItemRepository;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    ItemRegistrationResponse itemRegistrationResponse;
    @Override
    public ItemRegistrationResponse registerItem(ItemRegistrationRequest itemRegistrationRequest) {
        Item item = new Item();
        item.setId(itemRegistrationRequest.getId());
        item.setTitle(itemRegistrationRequest.getTitle());
        item.setAuctionStartTime(itemRegistrationRequest.getAuctionStartTime());
        item.setAuctionEndTime(itemRegistrationRequest.getAuctionEndTime());
        item.setAuctionOwner(itemRegistrationRequest.getAuctionOwner());
        item.setDescription(itemRegistrationRequest.getDescription());
        item.setStartingBid(itemRegistrationRequest.getStartingBid());

        Item savedItem = itemRepository.save(item);

        return new ItemRegistrationResponse(
                savedItem.getId(),
                savedItem.getTitle(),
                savedItem.getAuctionStartTime(),
                savedItem.getAuctionEndTime()
        );
    }


}
