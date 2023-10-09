package com.harbor.samples.bookInfo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.samples.bookInfo.DTOUtils;
import com.harbor.samples.bookInfo.models.User;
import com.harbor.samples.bookInfo.models.UserDTO;
import com.harbor.samples.bookInfo.services.UserService;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DTOUtils dtoUtils;

    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public UserDTO createBook(@RequestBody UserDTO userDto) {
        LOGGER.info("Creating user: {}", userDto);
        User user = dtoUtils.convertToUser(userDto);
        LOGGER.info("Converted user: {}", user);
        return dtoUtils.convertToUserDTO(userService.createUser(user));
    }

    @GetMapping("/user/{id}")
    public UserDTO getBookById(@PathVariable("id") Long id) {
        LOGGER.info("Getting user with id: {}", id);
        return dtoUtils.convertToUserDTO(userService.getUserById(id));
    }

    @PutMapping(value = "/user/{id}", consumes = "application/json", produces = "application/json")
    public UserDTO updateBook(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
        LOGGER.info("Updating user: {}", userDto);
        User user = dtoUtils.convertToUser(userDto);
        LOGGER.info("Converted user: {}", user);
        return dtoUtils.convertToUserDTO(userService.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        LOGGER.info("Deleting user with id: {}", id);
        userService.deleteUser(id);
    }

}
