package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Service;

/**
 * UserService Class
 * <p>
 * This class provides user-related services, specifically creating user objects.
 * <p>
 * Methods:
 * - createUser(String name, int age, String email): Creates a new User object with the specified attributes.
 * <p>
 * Note: The class is annotated with @Service, indicating it is a Spring-managed service.
 */
@Service
public class UserService {
    // По заданию №2 NotificationService выводит метод processRegistration() из класса RegistrationService
    // и чтобы вывод не дублировался, убрал отсюда и зависимость и само notifyUser с метода createUser(args..)

//    private NotificationService notificationService;
//
//    // Внедрение зависимости через конструктор
//    //@Autowired // не обязательно
//    public UserService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    /**
     * Create User
     * <p>
     * Creates a new User object with the specified attributes.
     *
     * @param name  String: The name of the new user.
     * @param age   int: The age of the new user.
     * @param email String: The email of the new user.
     * @return User: The newly created User object.
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

}
