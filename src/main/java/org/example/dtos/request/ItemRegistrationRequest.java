package org.example.dtos.request;

import lombok.Data;

import org.example.data.models.User;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class ItemRegistrationRequest {
    private String id;
    private String title;
    private String description;
    private String email;
    private LocalDate auctionStartDate;
    private LocalTime auctionStartTime;
    private LocalTime auctionEndTime;
    private double biddingPrice;
}
