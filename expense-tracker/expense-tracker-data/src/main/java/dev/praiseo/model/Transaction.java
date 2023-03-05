package dev.praiseo.model;

import dev.praiseo.enums.TransactionCategory;
import dev.praiseo.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Transaction extends BaseEntity{
    private String name;
    private Double amount;
    private TransactionType transactionType;
    private LocalDateTime createdAt;
    private User createdBy;
    private String description;
    private TransactionCategory transactionCategory;
}
