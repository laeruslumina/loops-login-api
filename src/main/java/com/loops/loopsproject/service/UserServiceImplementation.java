package com.loops.loopsproject.service;

import com.loops.loopsproject.models.entities.User;
import com.loops.loopsproject.models.repository.UserRepository;
import com.loops.loopsproject.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Status createUser(User user) {
        System.out.println("New User : " + user.toString());
        for (User priginal:getUsers()) {
            System.out.println("Registered user : " + user);
            if (priginal.equals(user)){
                System.out.println("User already exist!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(user);
        return Status.SUCCESS;
    }

    @Override
    public Status updateUser(Integer id, User user) {
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
        return Status.SUCCESS;
    }

    @Override
    public Status deleteUser(Integer id) {
        User userUpdate =userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User does not exist"));
        userRepository.delete(userUpdate);
        return Status.SUCCESS;
    }

    @Override
    public Status loginUser(User user) {
        for (User other:
             getUsers()) {
            if (other.equals(user)){
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @Override
    public Status logUserOut(User user) {
        getUsers();

        for (User other : getUsers()){
            if (other.equals(user)){
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
