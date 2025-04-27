package org.example.dtos.response;

import lombok.Generated;
import lombok.Getter;
import org.example.data.models.Item;

@Getter
public class UpdateItemResponse {
    boolean status;
    private String message;
    private String itemId;
}
