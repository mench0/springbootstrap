package com.example.web.springbootstrap.dao;


import com.example.web.springbootstrap.model.Role;
import com.example.web.springbootstrap.model.User;

import java.util.List;

public interface UserDao {
    User getByEmail(String email);
    User getByName(String name);
    void save(User user);
    User getById(Long id);
    void update(User user);
    void delete(Long id);
    List<User> getAll();
    Role getRole(String name);
    List<Role> getAllRoles();
}
