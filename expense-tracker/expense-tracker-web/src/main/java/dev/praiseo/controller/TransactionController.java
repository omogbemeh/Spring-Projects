package dev.praiseo.controller;

import dev.praiseo.model.Transaction;
import dev.praiseo.service.TransactionService;
import dev.praiseo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final UserService userService;
    private final TransactionService transactionService;

    public TransactionController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @GetMapping("")
    public ResponseEntity<Set<Transaction>> displayAllTransactions() {
        Set<Transaction> allTransactions = userService.getAllTransactionsByAUser();
        return new ResponseEntity<>(allTransactions, HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> displayATransaction(@PathVariable Long transactionId) {
        Transaction transaction = userService.getATransactionByAUser(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

}
