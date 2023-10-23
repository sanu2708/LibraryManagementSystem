package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.AuthorRequestDto;
import com.example.LibraryManagement_System.Entities.Author;
import com.example.LibraryManagement_System.Repositories.AuthorRepository;
import com.example.LibraryManagement_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {
        Author author= new Author();

        author.setId(authorRequestDto.getId());
        author.setName(author.getName());
        author.setAge(author.getAge());
        author.setBook(authorRequestDto.getBook());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);
        return "author added successfully";
    }
}
