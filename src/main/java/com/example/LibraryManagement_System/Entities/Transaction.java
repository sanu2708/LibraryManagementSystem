package com.example.LibraryManagement_System.Entities;

import com.example.LibraryManagement_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;

    private Boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
