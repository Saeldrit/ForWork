package com.example.mimicat.controller;

import com.example.mimicat.model.User;
import com.example.mimicat.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getCatList(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "/users/users";
    }

    @PostMapping("/user-add")
    public String catAdd(User user) {
        userService.addUser(user);
        return "redirect:/user-add";
    }

    @PostMapping("/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
