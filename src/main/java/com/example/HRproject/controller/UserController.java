package com.example.HRproject.controller;

import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {
    SystemUserRepo userRepo;

//    public String userList(Model model) {
//
//        model.addAttribute("users", userRepo.findAll());
//
//        return "userList";
//    }
@RequestMapping(value = "message", method = RequestMethod.GET)
public String messages(Model model) {
    model.addAttribute("messages", userRepo.findAll());
    return "userList";
}
}
