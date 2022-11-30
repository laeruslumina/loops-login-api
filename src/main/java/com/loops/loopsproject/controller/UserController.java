package com.loops.loopsproject.controller;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/show")
    public List<User> showUsers(){
        return userService.getUsers();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody @Valid User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable @Valid Integer id , @RequestBody @Valid User user){
        return  userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable @Valid Integer id){
        return userService.deleteUser(id);
    }
}
