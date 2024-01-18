package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    @Autowired // не обязательно, но по Best Practice лучше писать, т.к, читать код будет легче
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToRepository(newUser);
        notificationService.notifyUser(newUser);
    }
}
