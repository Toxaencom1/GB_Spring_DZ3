package com.taxah.spring_dz3.controllers;


import com.taxah.spring_dz3.domain.User;
import com.taxah.spring_dz3.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired // Пример инъекции через поле
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    // ---------------------------------------------------------------------------

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public Double calculateAverageAge() {
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }


}
