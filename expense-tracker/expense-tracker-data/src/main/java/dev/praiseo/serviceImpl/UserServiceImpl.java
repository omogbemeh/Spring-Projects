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

    @Override
    public Set<Transaction> getAllTransactionsByAUser() {
//        #TODO Remove hardcoded user
        User usr = userRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("User not Found"));
        return new HashSet<>(usr.getTransactions());
    }

    @Override
    public Transaction getATransactionByAUser(Long id) {
//        #TODO Remove hardcoded user
        User usr = userRepository.findById(1L).get();
        Transaction transaction = transactionService.getATransaction(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction Not Found"));
        return transaction;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

    @Override
    public Long countUsers() {
        return userRepository.count();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
