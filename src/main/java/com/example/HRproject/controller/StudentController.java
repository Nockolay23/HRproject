package com.example.HRproject.controller;

import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.domain.EducationalInstitution;
import com.example.HRproject.domain.StatusPractice;
import com.example.HRproject.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/studentList")
@PreAuthorize("hasAuthority('USER')")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping()
    public String userList(Model model) {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("{student}")
    public String studentEditForm(@PathVariable Student student, Model model) {
        List<StatusPractice> statuses = List.of(StatusPractice.values());
        model.addAttribute("student", student);
        model.addAttribute("statuses", statuses);

        return "studentEdit";
    }

    @PostMapping
    public String studentSave(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam String sex,
            @RequestParam java.sql.Date dateOfBirth,
            @RequestParam String contactDetails,
            @RequestParam String city,
//            @RequestParam EducationalInstitution educationalInstitution,
            @RequestParam Integer course,
            @RequestParam String faculty,
            @RequestParam String speciality,
            @RequestParam Integer numberPractices,
            @RequestParam java.sql.Date startDatePractice,
            @RequestParam java.sql.Date endDatePractice,
            @RequestParam String directionPractice,
            @RequestParam Double averageScoreForPractice,
            @RequestParam String review,
            @RequestParam Integer groupId,
            @RequestParam Map<String, String> form,
            @RequestParam("studentId") Student student
    ) {
        student.setName(name);
        student.setSurname(surname);
        student.setPatronymic(patronymic);
        student.setSex(sex);
        student.setDateOfBirth(dateOfBirth);
        student.setContactDetails(contactDetails);
        student.setCity(city);
//        student.setEducationalInstitution(educationalInstitution);
        student.setCourse(course);
        student.setFaculty(faculty);
        student.setSpeciality(speciality);
        student.setNumberPractices(numberPractices);
        student.setStartDatePractice(startDatePractice);
        student.setEndDatePractice(endDatePractice);
        student.setDirectionPractice(directionPractice);
        student.setAverageScoreForPractice(averageScoreForPractice);
        student.setReview(review);
        student.setGroupId(groupId);

        Set<String> statuses = Arrays.stream(StatusPractice.values())
                .map(StatusPractice::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (statuses.contains(key)) {
                student.setPracticeStatus(StatusPractice.valueOf(key));
            }
        }

        studentRepo.save(student);

        return "redirect:/studentList";
    }

}

