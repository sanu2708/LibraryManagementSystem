package com.example.LibraryManagement_System.Entities;


import com.example.LibraryManagement_System.Enums.Department;
import com.example.LibraryManagement_System.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor   // Lombok takes care of Constructors, getters and setters
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int noOfPages;
    private int price;
    private Boolean isBookIssued = false;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

}