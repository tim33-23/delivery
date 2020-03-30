package com.example.springwebcontent.repository;

import com.example.springwebcontent.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
