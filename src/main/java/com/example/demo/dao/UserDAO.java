package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;


public interface UserDAO extends JpaRepository<User, Integer>{
    @Query("SELECT u.password FROM User u where u.userName = ?1")
    String getPasswordByUserName(String password);
    @Query("SELECT u.role FROM User u where u.userName = ?1")
    String getRoleByUserName(String username);
}
