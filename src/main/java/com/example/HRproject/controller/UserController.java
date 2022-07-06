package com.example.HRproject.controller;

import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/userList")
@PreAuthorize("hasAuthority('Admin')")
public class UserController {
    @Autowired
    SystemUserRepo userRepo;

    @GetMapping()
    public String userList(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        List<Role> roles = List.of(Role.values());
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        user.setUsername(password);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().clear();
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/userList";
    }

}
