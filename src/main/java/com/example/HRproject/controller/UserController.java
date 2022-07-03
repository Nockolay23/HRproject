package com.example.HRproject.controller;

import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


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
        //List<Role> roles = List.of(Role.values());
        model.addAttribute("user", user);
        //model.addAttribute("roles", roles);

        return "userEdit";
    }

}
