package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegistrationService Class
 * <p>
 * This class provides registration services, handling the registration process for new users.
 * It collaborates with the DataProcessingService, UserService, and NotificationService to
 * create a new user, add the user to the repository, and notify about the registration event.
 * <p>
 * Dependencies:
 * - DataProcessingService: The service for processing user data.
 * - UserService: The service for creating user objects.
 * - NotificationService: The service for notifying about user-related events.
 * <p>
 * Methods:
 * - processRegistration(String name, int age, String email): Processes the registration for a new user,
 * creating the user, adding them to the repository, and notifying about the registration event.
 * - getDataProcessingService(): Retrieves the DataProcessingService instance.
 * <p>
 * Note: The class is annotated with @Service, indicating it is a Spring-managed service.
 */
@Service
public class RegistrationService {
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    /**
     * Constructor
     * <p>
     * Creates a new instance of RegistrationService with the specified dependencies.
     *
     * @param dataProcessingService DataProcessingService: The service for processing user data.
     * @param userService           UserService: The service for creating user objects.
     * @param notificationService   NotificationService: The service for notifying about user-related events.
     */
    @Autowired // не обязательно, но по Best Practice лучше писать, т.к, читать код будет легче
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Get Data Processing Service
     * <p>
     * Retrieves the DataProcessingService instance.
     *
     * @return DataProcessingService: The DataProcessingService instance.
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Process Registration
     * <p>
     * Processes the registration for a new user, creating the user, adding them to the repository,
     * and notifying about the registration event.
     *
     * @param name  String: The name of the new user.
     * @param age   int: The age of the new user.
     * @param email String: The email of the new user.
     */
    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToRepository(newUser);
        notificationService.notifyUser(newUser);
    }
}
