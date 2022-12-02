package com.loops.loopsproject.models.repository;

import com.loops.loopsproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
}