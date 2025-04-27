package org.example.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Document
public class Item {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalTime auctionStartTime;
    private LocalTime auctionEndTime;
    private LocalDate auctionStartDate;
    private String email;
    private double biddingPrice;
    private boolean isAvailable;
}
