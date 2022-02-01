package com.example.mimicat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping
    public String startPage() {
        return "/registration/signIn";
    }

    @GetMapping("/cat-add")
    public String catAdd() {
        return "cats/cat_add";
    }

    @GetMapping("/user-add")
    public String userAdd() {
        return "users/user_add";
    }
}
