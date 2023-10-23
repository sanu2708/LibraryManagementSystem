package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.Entities.Book;
import com.example.LibraryManagement_System.Services.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }
}
