package org.example.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
public class Item {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate auctionStartDate;
    private String email;
    private double startingBid;
    private boolean isAvailable;
}
