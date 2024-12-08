package com.example.spring_project.services;

import com.example.spring_project.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    org.apache.catalina.User resetPassword(Long id, String newPassword);

    org.apache.catalina.User toggleUnlocked(Long id);

    void deleteUser(Long id);

    List<org.apache.catalina.User> getAllUsers();
}
