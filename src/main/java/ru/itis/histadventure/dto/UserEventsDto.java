package ru.itis.histadventure.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEventsDto {
    private Long userId;
    private Long eventId;
}
