package org.example.dtos.response;

import lombok.Data;

@Data
public class UpdateItemResponse {
    private String itemId;
    boolean status;
    private String message;
}
