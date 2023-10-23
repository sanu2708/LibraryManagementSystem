package com.example.LibraryManagement_System.Entities;

import com.example.LibraryManagement_System.Enums.Department;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;
    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)  //Cascade used for reflecting changes of crud Operations in parent to child
    Card card;
}
