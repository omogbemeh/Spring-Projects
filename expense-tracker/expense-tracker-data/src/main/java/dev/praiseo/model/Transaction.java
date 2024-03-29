package dev.praiseo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.praiseo.enums.TransactionCategory;
import dev.praiseo.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity(name = "Transaction")
@Table(name = "transactions")
@NoArgsConstructor
public class Transaction extends BaseEntity{

    /**
     * Constructor for a transaction
     * @param title
     * @param amount
     * @param transactionType
     */
    public Transaction(String title, Double amount, TransactionType transactionType) {
        this.title = title;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    private String title;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    private String description;
    private TransactionCategory transactionCategory;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @Override
    public String toString() {
        return "Transaction{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
