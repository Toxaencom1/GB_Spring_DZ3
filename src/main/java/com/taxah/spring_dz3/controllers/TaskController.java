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

/**
 * TaskController Class
 *
 * This class serves as a RESTful controller for handling task-related operations.
 * It provides endpoints for retrieving a list of tasks, sorting users by age, filtering
 * users by age, and calculating the average age of users.
 *
 * Endpoints:
 * - GET /tasks: Retrieves a list of tasks.
 * - GET /tasks/sort: Sorts users by age.
 * - GET /tasks/filter/{age}: Filters users by age.
 * - GET /tasks/calc: Calculates the average age of users.
 *
 * Dependencies:
 * - DataProcessingService: Autowired service for processing data, including sorting,
 *   filtering, and calculating average age. *
 *
 * @RestController: Indicates that this class is a controller for handling RESTful requests.
 * @RequestMapping("/tasks"): Specifies the base URI path for mapping the controller's endpoints.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * DataProcessingService Dependency
     *
     * Autowired service for processing data, including sorting, filtering, and calculating
     * average age.
     */
    @Autowired // Пример инъекции через поле
    private DataProcessingService service;

    /**
     * Get All Tasks
     *
     * Retrieves a list of tasks.
     *
     * @return List<String>: A list of task names.
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Sort Users By Age
     *
     * Sorts users by age using the DataProcessingService.
     *
     * @return List<User>: A sorted list of users.
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    // ---------------------------------------------------------------------------

    /**
     * Filter Users By Age
     *
     * Filters users by age using the DataProcessingService.
     *
     * @param age int: The age to filter users by.
     * @return List<User>: A filtered list of users.
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }

    /**
     * Calculate Average Age
     *
     * Calculates the average age of users using the DataProcessingService.
     *
     * @return Double: The calculated average age.
     */
    @GetMapping("/calc")
    public Double calculateAverageAge() {
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }
}
