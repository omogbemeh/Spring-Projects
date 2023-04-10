package dev.praiseo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class User extends Person{
    public User(String firstName, String lastName, String username) {
        super(firstName, lastName);
        this.username = username;
    }

    public User() {
        super();
    }

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "createdBy",
               fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private Set<Transaction> transactions = new HashSet<>();

    public Transaction addTransaction(Transaction transaction) {
        try {
            this.transactions.add(transaction);
            transaction.setCreatedBy(this);
            return transaction;
        } catch (RuntimeException ex) {
            throw new RuntimeException("Error adding transaction");
        }

    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date updatedAt;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
