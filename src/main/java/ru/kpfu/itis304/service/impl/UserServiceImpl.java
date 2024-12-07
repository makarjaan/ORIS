package ru.kpfu.itis304.service.impl;

import ru.kpfu.itis304.dao.UserDao;
import ru.kpfu.itis304.dao.impl.UserDaoImpl;
import ru.kpfu.itis304.dto.UserDto;
import ru.kpfu.itis304.dto.UserRegistrationDto;
import ru.kpfu.itis304.entity.User;
import ru.kpfu.itis304.service.UserService;
import ru.kpfu.itis304.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getName(), null, u.getLastname())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        return null;
    }


    @Override
    public void register(UserRegistrationDto user) {
        userDao.save(new User(
                user.getName(),
                user.getLastName(),
                user.getLogin(),
                PasswordUtil.encrypt(user.getPassword())
        ));
    }
}
