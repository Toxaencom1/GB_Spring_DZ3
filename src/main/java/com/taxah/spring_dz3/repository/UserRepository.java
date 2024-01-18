package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepository Interface
 * <p>
 * This interface defines methods for interacting with a collection of User objects.
 * It serves as a contract for classes that provide data access to user-related operations,
 * such as retrieving a list of users and adding a new user.
 * <p>
 * Example Usage:
 * UserRepository userRepository = new UserRepositoryImpl();
 * List<User> userList = userRepository.getUsers();
 * User newUser = new User("John Doe", 25, "john.doe@example.com");
 * userRepository.addUser(newUser);
 * <p>
 * Methods:
 * - getUsers(): Retrieves a list of all users.
 * - addUser(User user): Adds a new user to the repository.
 * <p>
 * Implementations:
 * - Concrete classes implementing this interface provide actual data access logic.
 * Example: UserRepositoryImpl implements UserRepository.
 * <p>
 * Note: The interface serves as a contract, and the actual implementation may vary.
 *
 * @Repository: Indicates that this interface is a Spring Data repository.
 */
@Repository
public interface UserRepository {
    /**
     * Get Users
     * <p>
     * Retrieves a list of all users.
     *
     * @return List<User>: A list of all users in the repository.
     */
    List<User> getUsers();

    /**
     * Add User
     * <p>
     * Adds a new user to the repository.
     *
     * @param user User: The user to be added.
     */
    void addUser(User user);
}
