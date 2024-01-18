package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Service;

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

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

}
