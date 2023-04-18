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
}
