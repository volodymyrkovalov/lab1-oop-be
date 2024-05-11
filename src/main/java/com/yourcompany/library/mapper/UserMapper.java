package com.yourcompany.library.mapper;

import com.yourcompany.library.dto.UserDTO;
import com.yourcompany.library.model.User;

/**
 * Mapper for converting between User entity and UserDTO.
 */
public class UserMapper {

    /**
     * Converts a User entity to a UserDTO.
     * @param user The User entity.
     * @return The corresponding UserDTO.
     */
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        // Notice password is generally not set in DTO for security unless specifically needed
        return userDTO;
    }

    /**
     * Converts a UserDTO to a User entity.
     * @param userDTO The UserDTO.
     * @return The corresponding User entity.
     */
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());  // Ensure password handling is secure (e.g., hashing)
        return user;
    }
}
