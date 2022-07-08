package com.example.HRproject.controller;

import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/studentList")
@PreAuthorize("hasAuthority('USER')")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/studentList")
    public String studentList(Model model)
    {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "studentList";
    }
}
