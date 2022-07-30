package com.example.HRproject.controller;

import com.example.HRproject.Repos.RequestRepo;
import com.example.HRproject.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/requestList")
@PreAuthorize("hasAuthority('USER')")
public class RequestController {
    @Autowired
    RequestRepo requestRepo;

    @GetMapping()
    public String requestList(Model model) {
        List<Request> request = requestRepo.findAll();
        model.addAttribute("requests", request);
        return "requestList";
    }
    @GetMapping("{request}")
    public String requestEditForm(@PathVariable Request request, Model model) {
        List<StatusRequest> statuses = List.of(StatusRequest.values());
        model.addAttribute("request", request);
        model.addAttribute("statuses", statuses);
        return "requestEdit";
    }

    @PostMapping
    public String requestSave(
            @RequestParam Map<String, String> form,
            @RequestParam("requestId") Request request
    ) {
        Set<String> statuses = Arrays.stream(StatusRequest.values())
                .map(StatusRequest::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (statuses.contains(key)) {
                request.setRequestStatus(StatusRequest.valueOf(key));
            }
        }

        requestRepo.save(request);

        return "redirect:/requestList";
    }
}
