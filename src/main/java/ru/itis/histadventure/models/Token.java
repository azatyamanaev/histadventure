package ru.itis.histadventure.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
public class Token {
    private Long id;
    private String token;
}
