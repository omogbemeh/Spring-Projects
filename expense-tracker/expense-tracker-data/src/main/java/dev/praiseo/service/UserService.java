package dev.praiseo.service;

import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;

import java.util.Set;


public interface UserService {
    Set<Transaction> getAllTransactionsByAUser();
    Transaction getATransactionByAUser(Long id);
    User saveUser(User user);
    User updateUser(Long id, User user);
    Long countUsers();
    void deleteUser(User user);
    void deleteUserById(Long id);
}
