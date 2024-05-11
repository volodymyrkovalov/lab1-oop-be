package com.yourcompany.library.dto;

/**
 * User Data Transfer Object to encapsulate user data.
 */
public class UserDTO {
    private int id;
    private String username;
    private String email;
    // For security reasons, you might avoid including password here if not necessary for transfer
    private String password;

    // Default constructor
    public UserDTO() {
    }

    // Constructor with parameters
    public UserDTO(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;  // Consider security implications
    }

    // Getters and Setters
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
        this.password = password;  // Consider encryption or hashing before storing or transferring
    }

    // ToString method for debugging and logging purposes
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='*****'" +  // Mask password for security
                '}';
    }
}
