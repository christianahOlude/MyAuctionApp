package org.example.data.models;

import lombok.Data;

import java.util.List;

@Data
public class Bidder{
    private String id;
    private List<Item> itemList;
    private String userName;
    private String email;
    private String password;
}
