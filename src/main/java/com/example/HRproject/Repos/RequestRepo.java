package com.example.HRproject.Repos;

import com.example.HRproject.domain.Request;
import com.example.HRproject.domain.StatusRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {
    List<Request> findAllByRequestStatus(StatusRequest requestStatus);
    @Modifying
    @Query("update Request r set r.requestStatus = ?1 where r.requestId = ?2")
    int setFixedRequestStatusFor(StatusRequest requestStatus, Integer requestId);
}
