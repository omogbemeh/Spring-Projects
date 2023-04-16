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

    }
}
