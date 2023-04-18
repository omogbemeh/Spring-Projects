package dev.praiseo.ticketmanagement.service;

import dev.praiseo.ticketmanagement.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Integer userId);
    User createUser(User user);
    User updateUser(Integer userId, String username);
    void deleteUser(Integer userId);
}
