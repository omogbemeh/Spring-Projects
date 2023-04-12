package dev.praiseo.service;

import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface TransactionService {
    Set<Transaction> getAllTransactions();
    Set<Transaction> getAllTransactionsByUser(User user);
    Optional<Transaction> getATransaction(Long id);
    Transaction saveTransaction(Transaction transaction);
    Transaction updateTransaction(Long id, Transaction transaction);
    void deleteTransaction(Transaction transaction);
    void deleteTransactionById(Long id);
    Long countTransactions();
}
