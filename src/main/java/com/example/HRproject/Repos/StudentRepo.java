package com.example.HRproject.Repos;

import com.example.HRproject.domain.StatusPractice;
import com.example.HRproject.domain.StatusRequest;
import com.example.HRproject.domain.Student;
import com.example.HRproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByNameAndSurnameAndSexAndDateOfBirthAndContactDetails(String name, String surname, String sex, Date dateOfBirth, String contactDetails);

    List<Student> findByPracticeStatus(StatusPractice practiceStatus);

    Student findByStudentId(Integer studentId);

    @Modifying
    @Query("update Student s set s.practiceStatus = ?1 where s.studentId = ?2")
    int setFixedPracticeStatusFor(StatusPractice practiceStatus, Integer studentId);

    @Modifying
    @Query("update Student s set s.startDatePractice = ?1 where s.studentId = ?2")
    int setFixedStartDatePracticeFor(Date startDatePractice, Integer studentId);

    @Modifying
    @Query("update Student s set s.endDatePractice = ?1 where s.studentId = ?2")
    int setFixedEndDatePracticeFor(Date endDatePractice, Integer studentId);
}
