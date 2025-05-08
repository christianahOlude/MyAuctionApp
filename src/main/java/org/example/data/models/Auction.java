package org.example.data.models;

import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.util.List;

public class Auction {
    @Id
    private String id;
    private List<Item> items;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean status;
    private double price;
    private User winner;
}
