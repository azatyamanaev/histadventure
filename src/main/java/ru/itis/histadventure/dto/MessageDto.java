package ru.itis.histadventure.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String text;
    private String from;
    private String login;
}
