package com.example.frealsb.Managers;

import com.example.frealsb.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Security manager for managing user authentication and authorization.
 */
@Component
@AllArgsConstructor
public class SecurityManager {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    /**
     * Authenticate a user with the specified username and password.
     * @param username the username of the user
     * @param password the password of the user
     * @return the UserDetails object representing the authenticated user
     * @throws UsernameNotFoundException if the username is not found
     */
//    public UserDetails authenticate(String username, String password) throws UsernameNotFoundException {
//        // Logic to authenticate the user
//        return null;
//    }

    /**
     * Check if a user has the specified role.
     * @param user the UserDetails object representing the user
     * @param role the role to check
     * @return true if the user has the role, false otherwise
     */
//    public boolean hasRole(UserDetails user, String role) {
//        // Logic to check if the user has the specified role
//        return false;
//    }
}
