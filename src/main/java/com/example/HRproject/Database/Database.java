package com.example.HRproject.Database;

import com.example.HRproject.CreateRandomEntity.CreateRequest;
import com.example.HRproject.Repos.GroupRepo;
import com.example.HRproject.Repos.RequestRepo;
import com.example.HRproject.Repos.StudentRepo;
import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.User;

import java.util.ArrayList;
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
        List<User> userList = new ArrayList<>(userRepo.findUserByAccessLevelId(3));
        if(userList.size() == 0)
            userRepo.save(new User("Admin", "Admin", "Админ", "Админ", 3, true));

        userList.clear();
        userList.addAll(userRepo.findUserByAccessLevelId(2));
        if(userList.size() == 0)
            userRepo.save(new User("Kurator", "Kurator", "Куратор", "Куратор", 2,true));
    }
}
