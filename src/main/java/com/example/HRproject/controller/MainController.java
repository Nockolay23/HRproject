package com.example.HRproject.controller;

import com.example.HRproject.Database.Database;
import com.example.HRproject.Repos.GroupRepo;
import com.example.HRproject.Repos.RequestRepo;
import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Request;
import com.example.HRproject.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private GroupRepo groupRepo;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        Database.setGroupRepo(groupRepo);
        Database.setStudentRepo(studentRepo);
        Database.setRequestRepo(requestRepo);
        Database.setUserRepo(systemUserRepo);
        Database.check();

        return "home";
    }

    @GetMapping("/administrator")
    public String administrator(Map<String, Object> model) {
        return "administrator";
    }

    @GetMapping("/userList")
    public String userList(Map<String, Object> model) {
        return "userList";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Database.createRequest(1);
        return "main";
    }

    @PostMapping("/main")
    public String add(Map<String, Object> model){

        return "main";
    }
}

