package com.example.HRproject.Repos;

import com.example.HRproject.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SystemUserRepo extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
    List<User> findUserByAccessLevelId(Integer accessLevelId);

}
