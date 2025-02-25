package com.digibusy.EventEverEventService.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    @NonNull
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "category")
    private String category;
    @JsonProperty(value = "location")
    private String location;
    @JsonProperty(value = "startTime")
    private Instant startTime;
    @JsonProperty(value = "endTime")
    private Instant endTime;
    @JsonProperty(value = "price")
    private BigDecimal price;
    @JsonProperty(value = "capacity")
    private Integer capacity;
    @JsonProperty(value = "organizerId")
    private String organizerId;
    @JsonProperty(value = "status")
    private String status;
}
