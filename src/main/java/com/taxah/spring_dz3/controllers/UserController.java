package com.taxah.spring_dz3.controllers;


import com.taxah.spring_dz3.domain.User;
import com.taxah.spring_dz3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired // Пример инъекции через поле
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getUserRepository().addUser(user);
        return "User " + user.getName() + " added from body!";
    }

    @PostMapping("/add")
    public String userAddFromParam(@RequestParam String name,
                                   @RequestParam int age,
                                   @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User " + name + " was registered successfully";
    }
}
