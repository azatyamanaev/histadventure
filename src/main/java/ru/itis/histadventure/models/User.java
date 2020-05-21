package ru.itis.histadventure.models;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Transient
    private List<Event> createdEvents;
    @Transient
    private List<Event> subscribedEvents;
    private File image;


    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
