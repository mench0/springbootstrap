package com.example.web.springbootstrap.controller;

import com.example.web.springbootstrap.model.User;
import com.example.web.springbootstrap.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public String userPage(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", userService.getUserById(user.getId()));
		return "user";
	}

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}