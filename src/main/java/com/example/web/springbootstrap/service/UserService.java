package com.example.web.springbootstrap.service;


import com.example.web.springbootstrap.model.Role;
import com.example.web.springbootstrap.model.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User getUserByName(String name);
    void saveUser(User user);
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    Role getRole(String name);
    List<Role> getAllRoles();
}
