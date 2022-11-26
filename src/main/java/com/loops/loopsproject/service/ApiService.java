package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.User;

import java.util.List;

public interface ApiService {
    List<User> getUsers();

    String createUser(User user);

    String updateUser(Integer id, User user);

    String deleteUser(Integer id);

}
