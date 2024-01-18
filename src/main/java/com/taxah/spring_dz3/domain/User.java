package com.taxah.spring_dz3.domain;

/**
 * User Class
 * <p>
 * This class represents a user entity with attributes such as ID, name, age, and email.
 * It provides constructors for creating user objects with different sets of parameters.
 * Accessor and mutator methods are also provided for each attribute.
 * <p>
 * Attributes:
 * - id: An integer representing the unique identifier for the user.
 * - name: A string representing the name of the user.
 * - age: An integer representing the age of the user.
 * - email: A string representing the email address of the user.
 * <p>
 * Constructors:
 * - Default Constructor: Creates an empty User object.
 * - Parameterized Constructor (name, age, email): Creates a User object with specified attributes.
 * - Parameterized Constructor (id, name, age, email): Creates a User object with specified attributes and ID.
 * <p>
 * Accessor Methods:
 * - getId(): Retrieves the ID of the user.
 * - getName(): Retrieves the name of the user.
 * - getAge(): Retrieves the age of the user.
 * - getEmail(): Retrieves the email address of the user.
 * <p>
 * Mutator Methods:
 * - setId(int id): Sets the ID of the user.
 * - setName(String name): Sets the name of the user.
 * - setAge(int age): Sets the age of the user.
 * - setEmail(String email): Sets the email address of the user.
 */
public class User {
    private int id;
    private String name;
    private int age;
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(int id, String name, int age, String email) {
        this(name, age, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
