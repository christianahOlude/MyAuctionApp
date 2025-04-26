package org.example.dtos.request;

import lombok.Data;

import org.example.data.models.User;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class ItemRegistrationRequest {
    private String id;
    private String title;
    private String description;
    private User auctionOwner;
    private LocalDateTime auctionStartDate;
    private LocalDateTime auctionStartTime;
    private LocalDateTime auctionEndTime;
    private double startingBid;
}
