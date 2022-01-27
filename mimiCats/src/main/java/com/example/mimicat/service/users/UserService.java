package com.example.mimicat.service.users;

import com.example.mimicat.model.User;

import java.util.List;

public interface UserService {
    void updateUser(Integer id, User user);

    User getById(Integer id);

    List<User> getAll();

    void addUser(User user);

    void deleteUser(Integer id);
}
