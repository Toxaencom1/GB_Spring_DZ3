package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Service;

/**
 * NotificationService Class
 * <p>
 * This class provides notification services for user-related events, such as notifying
 * when a new user has been created. It allows for sending notifications to external systems
 * or logging events for monitoring purposes.
 * <p>
 * Methods:
 * - notifyUser(User user): Notifies about a user-related event, such as the creation of a new user.
 * <p>
 * Note: The class is annotated with @Service, indicating it is a Spring-managed service.
 */
@Service
public class NotificationService {
    /**
     * Notify User
     * <p>
     * Notifies about a user-related event, such as the creation of a new user.
     *
     * @param user User: The user for whom the notification is triggered.
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

}
