package dev.praiseo.serviceImpl;

import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;
import dev.praiseo.repository.UserRepository;
import dev.praiseo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public Set<Transaction> getAllTransactions() {
//        return new HashSet<>(userRepository.findByTransactions());
        return null;
    }

    @Override
    public Transaction getTransaction(Long id) {
//        return userRepository.findByTransactionsId(id);
        return null;
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
