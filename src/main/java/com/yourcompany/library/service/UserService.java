package com.yourcompany.library.service;

import com.yourcompany.library.dao.UserDAO;
import com.yourcompany.library.dto.UserDTO;
import com.yourcompany.library.mapper.UserMapper;
import com.yourcompany.library.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing users in the library system.
 */
public class UserService {
    private UserDAO userDAO;
    private UserMapper userMapper;

    public UserService() {
        this.userDAO = new UserDAO();
        this.userMapper = new UserMapper();
    }

    /**
     * Registers a new user.
     * @param userDTO The UserDTO containing the user's registration details.
     * @return true if the user is successfully registered, false otherwise.
     */
    public boolean registerUser(UserDTO userDTO) {
        try {
            userDTO.setPassword(encryptPassword(userDTO.getPassword())); // Encrypt the password before storing
            User user = userMapper.toEntity(userDTO);
            return userDAO.insert(user);
        } catch (Exception e) {
            // Log and handle the exception appropriately
            throw new RuntimeException("Failed to register user", e);
        }
    }

    /**
     * Authenticates a user based on username and password.
     * @param username The user's username.
     * @param password The user's password.
     * @return A UserDTO of the authenticated user or null if authentication fails.
     */
    public UserDTO validateUser(String username, String password) {
        try {
            User user = userDAO.findByUsername(username);
            if (user != null && user.getPassword().equals(encryptPassword(password))) {
                return userMapper.toDto(user);
            }
            return null;
        } catch (Exception e) {
            // Log and handle the exception appropriately
            throw new RuntimeException("Authentication failed", e);
        }
    }

    /**
     * Encrypts a password using SHA-256 and encodes it in Base64.
     * @param password The plain text password to encrypt.
     * @return The encrypted password.
     */
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Consider a runtime exception that fits your application's error handling policy
            throw new RuntimeException("Failed to hash password", e);
        }
    }
}
