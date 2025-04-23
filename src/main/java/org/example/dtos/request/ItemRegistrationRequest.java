package org.example.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.data.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ItemRegistrationRequest {
    @Id
    private String id;
    private String title;
    private String description;
    @DBRef
    private User auctionOwner;
    private LocalTime auctionStartTime;
    private LocalTime auctionEndTime;
    private double startingBid;
}
