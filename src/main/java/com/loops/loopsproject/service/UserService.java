package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.status.Status;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    Status createUser(User user);

    Status updateUser(Integer id, User user);

    Status deleteUser(Integer id);

    Status loginUser(User user);

    Status logUserOut(User user);
}
