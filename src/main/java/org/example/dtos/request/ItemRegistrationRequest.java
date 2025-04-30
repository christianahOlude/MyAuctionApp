package org.example.dtos.request;

import lombok.Data;


import java.time.LocalDate;

@Data
public class ItemRegistrationRequest {
    private String id;
    private String title;
    private String description;
    private String email;
    private LocalDate auctionStartDate;
    private double startingBid;
}
