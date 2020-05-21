package ru.itis.histadventure.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Transient
    private List<User> participants;
    private int capacity;
    private String host;
    private boolean active;
    private String place;
    private String timeStart;
    private String timeEnd;
    private Integer countLike;

    public Event(String name, String description, int capacity, String host, boolean active, String place, String timeStart, String timeEnd) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.host = host;
        this.active = active;
        this.place = place;
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
    }
}
