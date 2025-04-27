package org.example.dtos.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateItemRequest {
    private String title;
    private String description;
    private Double biddingPrice;
}
