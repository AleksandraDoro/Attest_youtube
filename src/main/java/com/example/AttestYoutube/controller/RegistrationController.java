package com.example.AttestYoutube.controller;

import com.example.AttestYoutube.domain.Role;
import com.example.AttestYoutube.domain.User;
import com.example.AttestYoutube.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller

public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration() {
        return "registration";

    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB !=null) {
            model.put("message", "Такой пользователь уже существует!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}
