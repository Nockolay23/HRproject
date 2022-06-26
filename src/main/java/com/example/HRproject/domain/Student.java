package com.example.HRproject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer studentId;

    private String name;
    private String surname;
    private String patronymic;
    private String sex;
    private Date dateOfBirth;
    private String contactDetails;
    private String city;
    private Integer course;
    private String faculty;
    private String speciality;
    private Integer numberPractices;
    private Date startDatePractice;
    private Date endDatePractice;
    private String directionPractice;
    private Double averageScoreForPractice;
    private String review;
    private Integer practiceStatusId;
    private Integer educationalInstitutionId;
    private Integer groupId;

    public Student(){
    }

    public Student(String name, String surname, String sex,
                   Date dateOfBirth, String contactDetails, String city, Integer course,
                   Integer numberPractices,
                   String directionPractice,
                   Integer practiceStatusId) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.contactDetails = contactDetails;
        this.city = city;
        this.course = course;
        this.numberPractices = numberPractices;
        this.directionPractice = directionPractice;
        this.practiceStatusId = practiceStatusId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getNumberPractices() {
        return numberPractices;
    }

    public void setNumberPractices(Integer numberPractices) {
        this.numberPractices = numberPractices;
    }

    public Date getStartDatePractice() {
        return startDatePractice;
    }

    public void setStartDatePractice(Date startDatePractice) {
        this.startDatePractice = startDatePractice;
    }

    public Date getEndDatePractice() {
        return endDatePractice;
    }

    public void setEndDatePractice(Date endDatePractice) {
        this.endDatePractice = endDatePractice;
    }

    public String getDirectionPractice() {
        return directionPractice;
    }

    public void setDirectionPractice(String directionPractice) {
        this.directionPractice = directionPractice;
    }

    public Double getAverageScoreForPractice() {
        return averageScoreForPractice;
    }

    public void setAverageScoreForPractice(Double averageScoreForPractice) {
        this.averageScoreForPractice = averageScoreForPractice;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getPracticeStatusId() {
        return practiceStatusId;
    }

    public void setPracticeStatusId(Integer practiceStatusId) {
        this.practiceStatusId = practiceStatusId;
    }

    public Integer getEducationalInstitutionId() {
        return educationalInstitutionId;
    }

    public void setEducationalInstitutionId(Integer educationalInstitutionId) {
        this.educationalInstitutionId = educationalInstitutionId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
