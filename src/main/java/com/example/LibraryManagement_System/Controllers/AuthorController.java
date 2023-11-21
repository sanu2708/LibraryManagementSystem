package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.DTO.RequestDTO.AuthorRequestDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.AuthorResponseDto;
import com.example.LibraryManagement_System.Entities.Author;
import com.example.LibraryManagement_System.Services.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/byEmail")
    public AuthorResponseDto getAuthorByEmail(@RequestParam ("email") String email)
    {
        return authorService.getAuthorByEmail(email);
    }
}
