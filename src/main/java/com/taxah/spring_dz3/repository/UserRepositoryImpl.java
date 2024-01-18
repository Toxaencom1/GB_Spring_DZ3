package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
