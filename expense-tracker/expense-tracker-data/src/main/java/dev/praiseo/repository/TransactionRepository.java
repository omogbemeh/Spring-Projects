package dev.praiseo.repository;

import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Set<Transaction> findAllByUser(User user);
}
