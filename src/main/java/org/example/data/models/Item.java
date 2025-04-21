package org.example.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class Item {
    @Id
    private int id;
    private String title;
    private String description;
    private LocalDateTime auctionTime;
    private Duration auctionDuration;
    private String auctionOwnerId;
    private double startingBid;
}
