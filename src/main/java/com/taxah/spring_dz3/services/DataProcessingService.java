package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import com.taxah.spring_dz3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DataProcessingService Class
 * <p>
 * This class provides data processing services, including sorting, filtering, and calculating
 * the average age of users. It acts as an intermediary between the user interface and the user
 * repository, facilitating operations on user data.
 * <p>
 * Dependencies:
 * - UserRepository: The repository for storing and retrieving user data.
 * <p>
 * Methods:
 * - sortUsersByAge(List<User> users): Sorts users by age.
 * - filterUsersByAge(List<User> users, int age): Filters users by age.
 * - calculateAverageAge(List<User> users): Calculates the average age of users.
 * - addUserToRepository(User user): Adds a new user to the user repository.
 * - getUserRepository(): Retrieves the user repository.
 * <p>
 * Note: The class is annotated with @Service, indicating it is a Spring-managed service.
 */
@Service
public class DataProcessingService {

    private UserRepository userRepository;

    /**
     * Constructor
     * <p>
     * Creates a new instance of DataProcessingService with the specified UserRepository dependency.
     *
     * @param userRepository UserRepository: The repository for storing and retrieving user data.
     */
    @Autowired
    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Sort Users By Age
     * <p>
     * Sorts users by age.
     *
     * @param users List<User>: The list of users to be sorted.
     * @return List<User>: A sorted list of users by age.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Filter Users By Age
     * <p>
     * Filters users by age.
     *
     * @param users List<User>: The list of users to be filtered.
     * @param age   int: The age threshold for filtering users.
     * @return List<User>: A filtered list of users by age.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Calculate Average Age
     * <p>
     * Calculates the average age of users.
     *
     * @param users List<User>: The list of users to calculate the average age.
     * @return double: The calculated average age of users.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Add User To Repository
     * <p>
     * Adds a new user to the user repository.
     *
     * @param user User: The user to be added to the repository.
     */
    public void addUserToRepository(User user) {
        userRepository.addUser(user);
    }

    /**
     * Get User Repository
     * <p>
     * Retrieves the user repository.
     *
     * @return UserRepository: The user repository.
     */
    public UserRepository getUserRepository() {
        return userRepository;
    }
}


