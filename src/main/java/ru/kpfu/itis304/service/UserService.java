package ru.kpfu.itis304.service;

import ru.kpfu.itis304.dto.UserDto;
import ru.kpfu.itis304.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDto get(int id);

    void register(UserRegistrationDto user);
}
