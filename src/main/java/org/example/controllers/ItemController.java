package org.example.controllers;

import org.example.data.models.Item;
import org.example.dtos.request.ItemRegistrationRequest;
import org.example.dtos.response.ItemRegistrationResponse;
import org.example.services.itemServices.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping("/registerItem")
//    public ResponseEntity<ItemRegistrationResponse> createItem(@RequestBody ItemRegistrationRequest itemRegistrationRequest) {
//        return new ResponseEntity<>(itemService.registerItem(itemRegistrationRequest), HttpStatus.OK);
//    }
    @PostMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

}
