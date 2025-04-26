package org.example.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class UserLoginResponse {
    public Object data;
    public String message;

}
