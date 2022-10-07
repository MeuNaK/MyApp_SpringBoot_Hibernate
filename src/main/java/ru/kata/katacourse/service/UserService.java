package ru.kata.katacourse.service;

import ru.kata.katacourse.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    User getUser(int id);

    void removeUser(int id);
}
