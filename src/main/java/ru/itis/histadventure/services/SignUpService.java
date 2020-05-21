package ru.itis.histadventure.services;

import ru.itis.histadventure.dto.SignUpDto;

public interface SignUpService {
    Boolean signUp(SignUpDto form);
}
