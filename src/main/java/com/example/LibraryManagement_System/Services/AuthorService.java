package com.example.LibraryManagement_System.Services;

import com.example.LibraryManagement_System.DTO.RequestDTO.AuthorRequestDto;
import com.example.LibraryManagement_System.Entities.Author;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);
}
