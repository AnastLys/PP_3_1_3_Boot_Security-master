package ru.kata.springboot_securitydemo.service;


import ru.kata.springboot_securitydemo.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> listUsers();

    User findUser(long id);

    void deleteUser(long id);

    void updeteUser(User user);

    User findByUsername(String username);
}
