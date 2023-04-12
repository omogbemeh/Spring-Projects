package dev.praiseo.controller;

import dev.praiseo.exception.ResourceNotFoundException;
import dev.praiseo.model.User;
import dev.praiseo.service.TransactionService;
import dev.praiseo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;
    private final TransactionService transactionService;

    public AdminController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    //    #TODO Allow only admins to view this page
    @GetMapping("/get-all-users")
    public ResponseEntity<Set<User>> displayAllUsers() {
        try {
            HashSet<User> users = new HashSet<>(userService.getAllUsers());
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException("Cannot get All users");
        }
    }

    //    #TODO Allow only admins to view this page
    @GetMapping("/get-user/{username}")
    public ResponseEntity<User> displayAUser(@PathVariable String username) {
        try {
            User user = userService.getAUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException("User with username " + username + " not found");
        }
    }
}
