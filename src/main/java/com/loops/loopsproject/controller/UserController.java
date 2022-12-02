package com.loops.loopsproject.controller;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.service.UserService;
import com.loops.loopsproject.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/user")
    public List<User> showUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Status createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public Status updateUser(@PathVariable Integer id , @RequestBody User user){
        return  userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public Status deleteUser(@PathVariable  Integer id){
        return userService.deleteUser(id);
    }

    @PostMapping("/user")
    public Status statusLogin(@RequestBody User user){return userService.loginUser(user);}

    @PostMapping("/user")
    public Status statusLogout(@RequestBody User user){return userService.logUserOut(user);}
}
