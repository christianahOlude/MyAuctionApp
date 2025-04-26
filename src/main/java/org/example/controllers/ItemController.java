package org.example.controllers;

import org.example.data.models.Item;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.services.itemServices.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ItemController {
//    @Autowired
//    private ItemService itemService;
//
//    @PostMapping
//    public ItemRegistrationResponse createItem(@RequestBody ItemRegistrationRequest item) {
//        return itemService.registerItem(item);
//    }

}
