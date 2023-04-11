package dev.praiseo.serviceImpl;

import dev.praiseo.model.Transaction;
import dev.praiseo.repository.TransactionRepository;
import dev.praiseo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Transaction> getAllTransactions() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Transaction getATransaction(Long id) {
        Optional<Transaction> transaction = repository.findById(id);
        if (transaction.isPresent()) return transaction.get();
        else throw new RuntimeException();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction foundTransaction = repository.findById(id)
                                                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setId(foundTransaction.getId());
        return repository.save(transaction);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        repository.delete(transaction);
    }

    @Override
    public void deleteTransactionById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Long countTransactions() {
        return repository.count();
    }
}
