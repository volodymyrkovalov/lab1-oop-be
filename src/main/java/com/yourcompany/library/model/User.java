package com.yourcompany.library.model;

/**
 * Represents a User entity in the database.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password; // Note: Password should be securely stored (e.g., hashed)

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; // Ensure that any setting of the password involves secure handling
    }

    // ToString method, usually for debugging, omitting the password for security
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
