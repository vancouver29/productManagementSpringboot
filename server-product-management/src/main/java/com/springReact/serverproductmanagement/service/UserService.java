package com.springReact.serverproductmanagement.service;

import com.springReact.serverproductmanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    //save can be used for update and insert operation in database
    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUsers();
}
