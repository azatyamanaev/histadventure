package ru.itis.histadventure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.histadventure.repositories.ParticipantsRepository;
import ru.itis.histadventure.repositories.UserEventsRepository;

@SpringBootApplication
public class HistadventureApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserEventsRepository userEventsRepository() {
        return new UserEventsRepository();
    }
    @Bean
    public ParticipantsRepository participantsRepository() {
        return new ParticipantsRepository();
    }


    public static void main(String[] args) {
        SpringApplication.run(HistadventureApplication.class, args);
    }

}
