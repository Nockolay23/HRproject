package com.example.HRproject.controller;

import com.example.HRproject.Database.Database;
import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private SystemUserRepo userRepo;
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model)
    {
        User userDb = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userDb != null)
        {
            model.addAttribute("message","Пользователь уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.Admin));
        userRepo.save(user);
        return "redirect:/login";
    }
}
