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
    public String createUser(@RequestBody @NonNull User user) {
        userRepository.save(user);
        return "User created..";
    }

    @Override
    public String updateUser(@PathVariable @NonNull Integer id, @RequestBody @NonNull User user) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));

        if (user.getEmail() != null){
            userUpdate.setEmail(user.getEmail());
        }
        if (user.getFullName() != null){
            userUpdate.setFullName(user.getFullName());
        }

        if (user.getPassword() != null){
            userUpdate.setPassword(user.getPassword());
        }


        userRepository.save(userUpdate);
        return "Updated...";
    }

    @Override
    public String deleteUser(@PathVariable @NonNull Integer id) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));
        userRepository.delete(userUpdate);
        return "User Deleted...";
    }
}
