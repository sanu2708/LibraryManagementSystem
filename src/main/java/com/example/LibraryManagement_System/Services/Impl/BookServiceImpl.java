package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.AuthorRequestDto;
import com.example.LibraryManagement_System.DTO.RequestDTO.BookRequestDto;
import com.example.LibraryManagement_System.Entities.Author;
import com.example.LibraryManagement_System.Entities.Book;
import com.example.LibraryManagement_System.Repositories.AuthorRepository;
import com.example.LibraryManagement_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {
        Author author;
        AuthorRequestDto authorRequestDto = new AuthorRequestDto();
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author Id not found!!");
        }
        author.getBook().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added Successfully";
    }

}
