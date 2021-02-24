package com.example.web.springbootstrap.controller;

import com.example.web.springbootstrap.model.Role;
import com.example.web.springbootstrap.model.User;
import com.example.web.springbootstrap.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String userList(@ModelAttribute("newUser") User newUser, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userService.getUserById(user.getId()));
        model.addAttribute("allRoles" , userService.getAllRoles());
        model.addAttribute("newUser", newUser);
        model.addAttribute("users", userService.getAllUsers());
        return "admin_panel";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "role", required = false) String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        if (roles != null) {
            for (String role : roles) {
                roleSet.add(userService.getRole(role));
            }
        }
        user.setRoles(roleSet);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    // редактирование при нажатии кнопки
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "role", required = false) String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        if (roles != null) {
            for (String role : roles) {
                roleSet.add(userService.getRole(role));
            }
        }
        user.setRoles(roleSet);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    //удаление пользователя
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
