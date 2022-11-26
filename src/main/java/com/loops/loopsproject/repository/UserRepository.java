package com.loops.loopsproject.repository;

import com.loops.loopsproject.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}