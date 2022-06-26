package com.example.HRproject.Repos;

import com.example.HRproject.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface SystemUserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
