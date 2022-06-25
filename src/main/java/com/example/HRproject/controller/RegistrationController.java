package com.example.HRproject.controller;

import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String addUser(User user, Map<String, Object> model)
    {
        User userDb = userRepo.findByUsername(user.getUsername());
        if (userDb != null)
        {
            model.put("message" , "User exist!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.Admin));
        userRepo.save(user);
        return "redirect:/login";
    }
}
