package org.example.dtos.request;

import lombok.Data;

@Data
public class DeleteItemRequest {
    private String itemId;
    private String userId;
}
