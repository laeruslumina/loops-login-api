package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiServiceImplementation implements ApiService{
    private  final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public String createUser(@RequestBody User user) {
        userRepository.save(user);
        return "User created..";
    }

    @Override
    public String updateUser(Integer id, User user) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));
        userUpdate.setFullName(user.getFullName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userRepository.save(userUpdate);
        return "Sukses...";
    }

    @Override
    public String deleteUser(Integer id) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));
        userRepository.delete(userUpdate);
        return "User Deleted...";
    }
}
