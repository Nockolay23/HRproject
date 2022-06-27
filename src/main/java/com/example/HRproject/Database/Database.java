package com.example.HRproject.Database;

import com.example.HRproject.Repos.SystemUserRepo;
import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Database {
    @Autowired
    private SystemUserRepo userRepo;

    public void check(){
        addUser();
    }

    public void addUser(){
        List<User> userList = new ArrayList<>(userRepo.findUserByAccessLevelId(3));
        if(userList.size() == 0)
            userRepo.save(new User("Admin", "Admin", "Админ", "Админ", 3));

        userList.clear();
        userList.addAll(userRepo.findUserByAccessLevelId(2));
        if(userList.size() == 0)
            userRepo.save(new User("Kurator", "Kurator", "Куратор", "Куратор", 2));
    }
}
