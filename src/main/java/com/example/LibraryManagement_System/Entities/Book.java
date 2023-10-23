package com.example.LibraryManagement_System.Entities;


import com.example.LibraryManagement_System.Enums.Department;
import com.example.LibraryManagement_System.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn
    Author author;

}