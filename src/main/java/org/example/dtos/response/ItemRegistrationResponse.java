package org.example.dtos.response;
import lombok.Data;


@Data
public class ItemRegistrationResponse {
    private String itemId;
    private String message;
    private boolean status;
    private String data;
}
