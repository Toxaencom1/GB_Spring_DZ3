package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    List<User> getUsers();

    void addUser(User user);

}
