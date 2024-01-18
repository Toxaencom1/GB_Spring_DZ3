package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * UserRepositoryImpl Class
 * <p>
 * This class provides an in-memory implementation of the UserRepository interface.
 * It stores user data in a List<User>, allowing the retrieval of users and addition
 * of new users to the in-memory repository.
 * <p>
 * Methods:
 * - getUsers(): Retrieves a list of all users from the in-memory repository.
 * - addUser(User user): Adds a new user to the in-memory repository.
 * <p>
 * Note: The class is annotated with @Component, indicating it is a Spring-managed component.
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    /**
     * UserRepositoryImpl Class
     * <p>
     * This class provides an in-memory implementation of the UserRepository interface.
     * It stores user data in a List<User>, allowing the retrieval of users and addition
     * of new users to the in-memory repository.
     * <p>
     * Example Usage:
     * UserRepository userRepository = new UserRepositoryImpl();
     * List<User> userList = userRepository.getUsers();
     * User newUser = new User("John Doe", 25, "john.doe@example.com");
     * userRepository.addUser(newUser);
     * <p>
     * Methods:
     * - getUsers(): Retrieves a list of all users from the in-memory repository.
     * - addUser(User user): Adds a new user to the in-memory repository.
     * <p>
     * Note: The class is annotated with @Component, indicating it is a Spring-managed component.
     */
    @Override
    public List<User> getUsers() {
        return users;
    }

    /**
     * Add User
     * <p>
     * Adds a new user to the in-memory repository.
     *
     * @param user User: The user to be added.
     */
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
