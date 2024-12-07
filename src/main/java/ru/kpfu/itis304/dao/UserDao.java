package ru.kpfu.itis304.dao;

import ru.kpfu.itis304.entity.User;

import java.util.List;

public interface UserDao {

    User get(int id);


    List<User> getAll();

    void save(User user);

}
