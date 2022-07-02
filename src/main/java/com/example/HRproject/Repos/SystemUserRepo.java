package com.example.HRproject.Repos;

import com.example.HRproject.domain.Role;
import com.example.HRproject.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    List<User> findUserByRoles(Role roles);
}

//public interface SystemUserRepo extends CrudRepository<User, Integer> {
//    User findByUsernameAndPassword(String username, String password);
//    List<User> findUserByRoles(Role roles);
//
//}
