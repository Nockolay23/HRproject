package com.example.HRproject.Repos;

import com.example.HRproject.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findByNameAndSurnameAndSexAndDateOfBirthAndContactDetails(String name, String surname, String sex, Date dateOfBirth, String contactDetails);
}
