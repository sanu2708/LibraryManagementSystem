package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.DTO.RequestDTO.AuthorRequestDto;
import com.example.LibraryManagement_System.Entities.Author;
import com.example.LibraryManagement_System.Services.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
        return authorService.addAuthor(authorRequestDto);
    }
}
