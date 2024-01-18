package com.taxah.spring_dz3.controllers;


import com.taxah.spring_dz3.domain.User;
import com.taxah.spring_dz3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController Class
 * <p>
 * This class serves as a RESTful controller for handling user-related operations.
 * It provides endpoints for retrieving a list of users, adding users from the request body,
 * and registering users with parameters.
 * <p>
 * Endpoints:
 * - GET /user: Retrieves a list of all users.
 * - POST /user/body: Adds a user from the request body.
 * - POST /user/add: Registers a user with parameters (name, age, email).
 * <p>
 * Dependencies:
 * - RegistrationService: Autowired service for user registration and data processing.
 *
 * @RestController: Indicates that this class is a controller for handling RESTful requests.
 * @RequestMapping("/user"): Specifies the base URI path for mapping the controller's endpoints.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * RegistrationService Dependency
     * <p>
     * Autowired service for user registration and data processing.
     */
    @Autowired // Пример инъекции через поле
    private RegistrationService service;

    /**
     * User List
     * <p>
     * Retrieves a list of all users.
     *
     * @return List<User>: A list of all registered users.
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getUserRepository().getUsers();
    }

    /**
     * Add User From Body
     * <p>
     * Adds a user from the request body.
     *
     * @param user User: The user to be added.
     * @return String: A message indicating the success of the user addition.
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getUserRepository().addUser(user);
        return "User " + user.getName() + " added from body!";
    }

    /**
     * Add User From Param
     * <p>
     * Registers a user with parameters (name, age, email).
     *
     * @param name  String: The name of the user.
     * @param age   int: The age of the user.
     * @param email String: The email of the user.
     * @return String: A message indicating the success of user registration.
     */
    @PostMapping("/add")
    public String userAddFromParam(@RequestParam String name,
                                   @RequestParam int age,
                                   @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User " + name + " was registered successfully";
    }
}
