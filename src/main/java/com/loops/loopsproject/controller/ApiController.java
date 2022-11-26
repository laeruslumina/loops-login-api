package com.loops.loopsproject.controller;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.service.ApiService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/show")
    public List<User> showUsers(){
        return apiService.getUsers();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody @NonNull User user){
        return apiService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable @NonNull Integer id ,@RequestBody @NonNull User user){
        return  apiService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable @NonNull Integer id){
        return apiService.deleteUser(id);
    }
}
