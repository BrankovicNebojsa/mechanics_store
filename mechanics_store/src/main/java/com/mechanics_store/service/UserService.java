package com.mechanics_store.service;

import com.mechanics_store.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.mechanics_store.repository.UserRepository;

/**
 * Contains business logic for a User class
 *
 * Class that's used to control and manipulate data related to user class.
 * Enables creating, reading, updating and deleting a user.
 *
 * @author Nebojsa Brankovic
 */
@Service
public class UserService {

    /**
     * Broker for user table in database
     */
    private final UserRepository userRepository;

    /**
     * Parametrized constructor that automatically injects all dependencies
     * through Spring.
     *
     * @param userRepository Class that implements all necessary operations
 for working with table User in database.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Method that returns list of all users in database.
     *
     * @return list of all users
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Method that returns user who is currently logged in the system.
     *
     * @return user who is currently logged in the system.
     */
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * Method that checks if the currently logged in user is a worker.
     *
     * @return is currently logged in user a worker.
     */
    public Boolean isCurrentUserAWorker() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("WORKER"));
    }

    /**
     * Method that updates information for a user.
     *
     * @param user User with new data to be stored.
     * @return Updated user who's data is stored in database.
     */
    public User updateUser(User user) {
        userRepository.findById(user.getId()).ifPresent(userRepository::save);
        return userRepository.save(user);
    }

    /**
     * Method that updates data for a user.
     *
     * If an error occurs or there is no such user, method returns null
     *
     * @param id Identifier of a user who is to be updated.
     * @param fields Fields that should be updated.
     * @return Updated user who's data is stored in database.
     */
    public User updateUser(Long id, Map<String, Object> fields) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }
}
