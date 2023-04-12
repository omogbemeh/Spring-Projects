package dev.praiseo.serviceImpl;

import dev.praiseo.exception.ResourceNotFoundException;
import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;
import dev.praiseo.repository.UserRepository;
import dev.praiseo.service.TransactionService;
import dev.praiseo.service.UserService;
import org.springframework.stereotype.Repository;

import java.lang.module.ResolutionException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TransactionService transactionService;

    public UserServiceImpl(UserRepository userRepository, TransactionService transactionService) {
        this.userRepository = userRepository;
        this.transactionService = transactionService;
    }

    /**
     * Gets all users in the db
     * @return
     */
    @Override
    public Set<User> getAllUsers() {
        return new HashSet<>(userRepository.findAll());
    }

    /**
     * Gets a user by their username
     * @param username the user's username
     * @return a user or throws a resource not found exception
     */
    @Override
    public User getAUserByUsername(String username) {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " not found"));
        return user;
    }

    @Override
    public Set<Transaction> getAllTransactionsByAUser() {
//        #TODO Remove hardcoded user
        try {
            User usr = userRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("User not Found"));
            return transactionService.getAllTransactionsByUser(usr);
        } catch (ResourceNotFoundException ex) {
            throw new RuntimeException("Cannot get all transactions");
        }
    }

    @Override
    public Transaction getATransactionByAUser(Long id) {
//        #TODO Remove hardcoded user
        User usr = userRepository.findById(1L).get();
        Transaction transaction = transactionService.getATransaction(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction Not Found"));
        if (transaction.getUser().equals(usr)) return transaction;
        throw new ResourceNotFoundException("Transaction with id: " + id + " not found");
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

//    TODO: allow only admins access this path
    @Override
    public Long countUsers() {
        return userRepository.count();
    }

//    TODO: allow only admins access this pat
    @Override
    public void deleteUser(User user) {

    }

//    TODO: allow only admins access this path
    @Override
    public void deleteUserById(Long id) {

    }
}
