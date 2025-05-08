package org.example.dtos.request;

import lombok.Data;
import org.example.data.models.Item;

@Data
public class PlaceBidRequest {
    public Item itemId;
    private Double amount;

}
