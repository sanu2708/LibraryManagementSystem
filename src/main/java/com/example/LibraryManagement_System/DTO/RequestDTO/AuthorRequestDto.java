package com.example.LibraryManagement_System.DTO.RequestDTO;

import com.example.LibraryManagement_System.Entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class AuthorRequestDto {
    private int id;
    private String name;
    private int age;
    private String email;
    List<Book> book = new ArrayList<>();
}
