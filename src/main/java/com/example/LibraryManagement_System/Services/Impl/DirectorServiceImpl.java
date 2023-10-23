package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.DirectorRequestDTO;
import com.example.LibraryManagement_System.Entities.Director;
import com.example.LibraryManagement_System.Repositories.DirectorRepository;
import com.example.LibraryManagement_System.Services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    DirectorRepository directorRepository;
    @Override
    public String addDirector(DirectorRequestDTO directorRequestDTO) {
        Director director = new Director();
        director.setName(directorRequestDTO.getName());
        director.setAge(directorRequestDTO.getAge());
        directorRepository.save(director);
        return "Director added";
    }
}
