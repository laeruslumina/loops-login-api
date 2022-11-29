package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private  final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created..";
    }

    @Override
    public String updateUser(Integer id, User user) {
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
    public String deleteUser(Integer id) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));
        userRepository.delete(userUpdate);
        return "User Deleted...";
    }
}
