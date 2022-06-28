package com.example.HRproject.Repos;

import com.example.HRproject.domain.Request;
import com.example.HRproject.domain.StatusRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepo extends CrudRepository<Request, Integer> {
    List<Request> findAllByRequestStatus(StatusRequest requestStatus);
}
