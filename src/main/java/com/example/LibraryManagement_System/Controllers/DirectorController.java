package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.DTO.RequestDTO.DirectorRequestDTO;
import com.example.LibraryManagement_System.Entities.Director;
import com.example.LibraryManagement_System.Services.Impl.DirectorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    DirectorServiceImpl directorService;
    @PostMapping("/add")
    public String addDirector(@RequestBody DirectorRequestDTO directorRequestDTO)
    {
       return directorService.addDirector(directorRequestDTO);
    }
}
