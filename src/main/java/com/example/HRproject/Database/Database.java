package com.example.HRproject.Database;

import com.example.HRproject.CreateRandomEntity.CreateRequest;
import com.example.HRproject.Repos.GroupRepo;
import com.example.HRproject.Repos.RequestRepo;
import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    private static  SystemUserRepo userRepo;
    private static RequestRepo requestRepo;
    private static StudentRepo studentRepo;
    private static GroupRepo groupRepo;

    private static CreateRequest createRequest;

    public static void setUserRepo(SystemUserRepo userRepo) {
        Database.userRepo = userRepo;
    }

    public static void setRequestRepo(RequestRepo requestRepo) {
        Database.requestRepo = requestRepo;
    }

    public static void setStudentRepo(StudentRepo studentRepo) {
        Database.studentRepo = studentRepo;
    }

    public static void setGroupRepo(GroupRepo groupRepo) {
        Database.groupRepo = groupRepo;
    }

    public static void check(){
        //addUser();
        createRequest = new CreateRequest(studentRepo, requestRepo);
    }

    public static void createRequest(int count){
        for (int i = 0; i < count; i++)
            createRequest.addRequest();
    }

    public static void addUser(){
        List<User> userList = new ArrayList<>(userRepo.findUserByRoles(Role.Admin));
        if(userList.size() == 0)
            userRepo.save(new User("Admin", "Admin", "Админ", "Админ", Role.Admin, true));

        userList.clear();
        userList.addAll(userRepo.findUserByRoles(Role.USER));
        if(userList.size() == 0)
            userRepo.save(new User("Kurator", "Kurator", "Куратор", "Куратор", Role.USER,true));
    }

    static void updateRequest(Request request, StatusRequest newStatus){
        requestRepo.setFixedRequestStatusFor(newStatus, request.getRequestId());
        switch (newStatus){
            case ACTIVE:
                studentRepo.setFixedPracticeStatusFor(StatusPractice.ACTIVE, request.getStudentId());
                studentRepo.setFixedStartDatePracticeFor(new Date(), request.getStudentId());
                break;
            case PASSED:
                studentRepo.setFixedPracticeStatusFor(StatusPractice.PASSED, request.getStudentId());
                studentRepo.setFixedEndDatePracticeFor(new Date(), request.getStudentId());
                break;
            case CANCELED:
                studentRepo.setFixedPracticeStatusFor(StatusPractice.CANCELED, request.getStudentId());
                break;
        }
    }

    public static Student getStudent(Request request){
        return studentRepo.findByStudentId(request.getStudentId());
    }

    public static List<Request> getRequestByStatus(StatusRequest statusRequest){
        return requestRepo.findAllByRequestStatus(statusRequest);
    }

    public static List<User> getUserByRole(Role role){
        return userRepo.findUserByRoles(role);
    }

}
