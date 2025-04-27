package org.example.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class UserLoginResponse {
    private Object data;
    private String userId;
    private String message;

}
