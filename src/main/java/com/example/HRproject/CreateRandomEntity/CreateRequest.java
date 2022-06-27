package com.example.HRproject.CreateRandomEntity;

import com.example.HRproject.Repos.RequestRepo;
import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.domain.Request;
import com.example.HRproject.domain.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CreateRequest {
    StudentRepo studentRepo;
    RequestRepo requestRepo;

    public CreateRequest(StudentRepo studentRepo, RequestRepo requestRepo) {
        this.studentRepo = studentRepo;
        this.requestRepo = requestRepo;
    }

    public void addRequest(){
        try {
            Student student = addStudent();
            studentRepo.save(student);
            List<Student> students =  studentRepo.findByNameAndSurnameAndSexAndDateOfBirthAndContactDetails(student.getName(),
                    student.getSurname(), student.getSex(), student.getDateOfBirth(), student.getContactDetails());
            Request request = new Request(new Date(), students.get(students.size() - 1).getStudentId(), 1);
            requestRepo.save(request);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public Student addStudent() throws ParseException {
        Random rnd = new Random();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        String[] name = new String[]{"Валерий", "Генадий", "Димитрий", "Василий", "Валентин"};
        String[] surname = new String[]{"Гречухин", "Виноградов", "Смирнов", "Пшенин", "Гениев"};
        String[] sex = new String[]{"МЖ"};
        String[] dateOfBirth = new String[]{"12.01.2002", "12.02.2002", "12.03.2002", "12.04.2002", "12.05.2002"};
        String[] contactDetails = new String[]{"tg - @12313", "mail - asdasd@mail.com", "mail - asdasd@gmail.com"};
        String[] city = new String[]{"Москва", "Кострома", "Иваново", "Питер"};
        Integer[] course = new Integer[]{2, 3, 4, 5};
        Integer[] numberPractices = new Integer[]{0, 1, 2, 3};
        String[] directionPractice = new String[]{"Разработка", "Верстка", "Дизайн", "Аналитика"};
        Integer practiceStatusId = 0;

        return new Student(
                name[rnd.nextInt(name.length)],
                surname[rnd.nextInt(surname.length)],
                sex[rnd.nextInt(sex.length)],
                format.parse(dateOfBirth[rnd.nextInt(dateOfBirth.length)]),
                contactDetails[rnd.nextInt(contactDetails.length)],
                city[rnd.nextInt(city.length)],
                course[rnd.nextInt(course.length)],
                numberPractices[rnd.nextInt(numberPractices.length)],
                directionPractice[rnd.nextInt(directionPractice.length)],
                practiceStatusId);
    }
}
