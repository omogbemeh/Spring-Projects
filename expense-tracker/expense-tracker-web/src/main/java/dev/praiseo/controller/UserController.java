package dev.praiseo.controller;

import dev.praiseo.exception.ResourceNotFoundException;
import dev.praiseo.model.User;
import dev.praiseo.repository.UserRepository;
import dev.praiseo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    #TODO Allow only admins to view this page
    @GetMapping("")
    public final ResponseEntity<Set<User>> displayAllUsers() {
        try {
            HashSet<User> users = new HashSet<>(userRepository.findAll());
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResourceNotFoundException("Cannot find users");
        }
    }
}
