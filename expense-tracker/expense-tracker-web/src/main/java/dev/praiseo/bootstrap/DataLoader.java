package dev.praiseo.bootstrap;

import dev.praiseo.enums.TransactionType;
import dev.praiseo.model.Transaction;
import dev.praiseo.model.User;
import dev.praiseo.service.TransactionService;
import dev.praiseo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private Logger log = LoggerFactory.getLogger(DataLoader.class);
    private UserService userService;
    private TransactionService transactionService;

    public DataLoader(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("****************************");
        log.info("Creating a user");
        User usr = new User("Praise", "Omogbemeh", "praise_o");
        userService.saveUser(usr);
        log.info(usr.toString());

        log.info("****************************");
        log.info("Creating a transaction");
        Transaction transaction = new Transaction("Groceries", 33.00, TransactionType.DEBIT);
        transactionService.saveTransaction(transaction);

//        log.info("****************************");
//        log.info("Creating a transaction");
//        Transaction transaction2 = new Transaction("Subscription", 213.00, TransactionType.DEBIT, usr);
//        transactionService.saveTransaction(transaction2);
//
//        usr.addTransaction(transaction);
//        userService.saveUser(usr);
//
//        usr.addTransaction(transaction2);
//        userService.saveUser(usr);
//
//        log.info(usr.getTransactions().toString());
//        log.info(transaction.toString());
//
//        log.info("Finished creating a user and a transaction");
//
//        log.info("Number of people in the database after creating a user is: " + userService.countUsers());
//        log.info("Number of transactions in the database after creating a transaction is: " + transactionService.countTransactions());
    }
}
