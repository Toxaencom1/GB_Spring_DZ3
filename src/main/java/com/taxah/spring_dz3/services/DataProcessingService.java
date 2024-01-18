package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import com.taxah.spring_dz3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    private UserRepository userRepository;

    @Autowired
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void addUserToRepository(User user) {
        userRepository.addUser(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}


