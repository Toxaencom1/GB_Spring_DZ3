package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Primary
public class UserRepositoryH2 implements UserRepository {
    private final JdbcTemplate jdbc;


    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, (resultSet, rowNum) ->
                new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")
                )
        );
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
