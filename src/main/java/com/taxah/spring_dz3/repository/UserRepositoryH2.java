package com.taxah.spring_dz3.repository;


import com.taxah.spring_dz3.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * UserRepositoryH2 Class
 * <p>
 * This class provides an implementation of the UserRepository interface using the H2 database.
 * It utilizes the Spring JdbcTemplate for database interaction, allowing the retrieval of users
 * and addition of new users to an H2 database table named "userTable".
 * <p>
 * Dependencies:
 * - JdbcTemplate: The Spring JdbcTemplate for database interaction.
 * <p>
 * Methods:
 * - getUsers(): Retrieves a list of all users from the "userTable".
 * - addUser(User user): Adds a new user to the "userTable".
 * <p>
 * Note: The class is annotated with @Repository and @Primary, indicating it is a Spring Data repository
 * and should be considered as the primary bean when multiple beans of the same type exist.
 */
@Repository
@Primary
public class UserRepositoryH2 implements UserRepository {
    private final JdbcTemplate jdbc;

    /**
     * Constructor
     * <p>
     * Creates a new instance of UserRepositoryH2 with the specified JdbcTemplate dependency.
     *
     * @param jdbc JdbcTemplate: The Spring JdbcTemplate for database interaction.
     */
    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Get Users
     * <p>
     * Retrieves a list of all users from the "userTable".
     *
     * @return List<User>: A list of all users in the "userTable".
     */
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

    /**
     * Add User
     * <p>
     * Adds a new user to the "userTable".
     *
     * @param user User: The user to be added.
     */
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO userTable (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}
