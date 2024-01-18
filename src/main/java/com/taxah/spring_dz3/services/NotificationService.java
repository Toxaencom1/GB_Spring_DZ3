package com.taxah.spring_dz3.services;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

}
