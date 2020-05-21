package ru.itis.histadventure.services;

import ru.itis.histadventure.dto.LogInDto;

public interface LogInService {
    Boolean logIn(LogInDto form);
}
