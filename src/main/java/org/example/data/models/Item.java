package org.example.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@Document
public class Item {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime auctionStartTime;
    private LocalDateTime auctionEndTime;
    private LocalDateTime auctionStartDate;
    @DBRef
    private User auctionOwner;
    private double startingBid;
}
