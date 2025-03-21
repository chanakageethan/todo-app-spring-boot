package com.example.todo.repo;


import com.example.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM user WHERE username=?1", nativeQuery = true)
    Optional<User> findUserById(String username);
}


