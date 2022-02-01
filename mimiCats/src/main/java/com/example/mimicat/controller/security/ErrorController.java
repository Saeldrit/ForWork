package com.example.mimicat.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/403")
    public String get403() {
        return "/errors/error403";
    }

    @GetMapping("/error/404")
    public String get404() {
        return "/errors/error404";
    }

    @GetMapping("/error/500")
    public String get500() {
        return "/errors/error500";
    }
}
