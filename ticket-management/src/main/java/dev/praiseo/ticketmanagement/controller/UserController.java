package dev.praiseo.ticketmanagement.controller;

import dev.praiseo.ticketmanagement.model.User;
import dev.praiseo.ticketmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Map<String, String> getUser(@PathVariable Integer userId) {
        Map<String, String> users = new LinkedHashMap<>();
        users.put("result", "Getting a user with id: " + userId + "");
        return users;
    }

    @PostMapping("")
    public Map<String, String> createUser(@RequestBody User user) {
        Map<String, String> users = new LinkedHashMap<>();
        users.put("result", "Created a new user with id: " + user.getUserid() + "");
        return users;
    }

    @PutMapping("/{userId}")
    public Map<String, String> updateUser(@PathVariable Integer userId) {
        Map<String, String> users = new LinkedHashMap<>();
        users.put("result", "Updating user with id: " + userId + "");
        return users;
    }

    @DeleteMapping("/{userId}")
    public Map<String, String> deleteUser(@PathVariable Integer userId) {
        Map<String, String> users = new LinkedHashMap<>();
        users.put("result", "Deleting a user with id: " + userId + "");
        return users;
    }

}
