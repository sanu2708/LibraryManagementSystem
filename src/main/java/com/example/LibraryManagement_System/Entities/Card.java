package com.example.LibraryManagement_System.Entities;


import com.example.LibraryManagement_System.Enums.CardStatus;
import com.example.LibraryManagement_System.Enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@NoArgsConstructor   // Lombok takes care of Constructors, getters and setters
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp  //auto fill realtime
    Date issueDate;
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;
    private String validTill;
    @OneToOne
    @JoinColumn
    Student student;

}
