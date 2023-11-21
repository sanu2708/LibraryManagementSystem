package com.example.LibraryManagement_System.DTO.RequestDTO;

import com.example.LibraryManagement_System.Entities.Author;
import com.example.LibraryManagement_System.Entities.Book;
import com.example.LibraryManagement_System.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;
    private Genre genre;
    private int noOfPages;
    private int price;
    Author author;
}
