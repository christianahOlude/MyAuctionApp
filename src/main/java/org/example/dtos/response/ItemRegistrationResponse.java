package org.example.dtos.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Document
@AllArgsConstructor
public class ItemRegistrationResponse {
    @Id
    private String id;
    private String title;
    private LocalTime auctionStartTime;
    private LocalTime auctionEndTime;

}
