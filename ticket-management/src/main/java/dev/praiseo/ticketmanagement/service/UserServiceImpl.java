package dev.praiseo.ticketmanagement.service;

import dev.praiseo.ticketmanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public static List<User> users = new LinkedList<>();

    public UserServiceImpl() {
        users.add(new User(1, "praise"));
        users.add(new User(2, "faith"));
        users.add(new User(3, "divine"));
        users.add(new User(4, "precious"));
        users.add(new User(5, "gunn"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(Integer userId) {
        return users.stream().filter(user -> user.getUserId() == userId)
                             .findAny()
                             .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(Integer userId, String username) {
        User founduser = users.stream().filter(user -> user.getUserId() == userId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("User with ID: " + userId + " not found"));
        founduser.setUsername(username);
        return founduser;
    }

    @Override
    public void deleteUser(Integer userId) {
        users.removeIf(user -> user.getUserId() == userId);
    }
}
