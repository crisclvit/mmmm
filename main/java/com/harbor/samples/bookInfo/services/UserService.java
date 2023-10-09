package com.harbor.samples.bookInfo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.User;
import com.harbor.samples.bookInfo.repositories.UserRepo;

@Service
public class UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        LOGGER.info("Creating User: {}", user);
        return userRepo.save(user);
    }

    public User getUserById(Long id) {
        LOGGER.info("Getting User with id: {}", id);
        return userRepo.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        LOGGER.info("Updating User: {}", user);
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        LOGGER.info("Deleting User with id: {}", id);
        userRepo.deleteById(id);
    }
}
