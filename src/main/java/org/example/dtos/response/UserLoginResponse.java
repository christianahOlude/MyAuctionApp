package org.example.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
public class UserLoginResponse {
    @Id
    public String id;
    public String userName;
    public String message;


}
