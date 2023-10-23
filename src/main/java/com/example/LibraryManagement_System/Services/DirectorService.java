package com.example.LibraryManagement_System.Services;

import com.example.LibraryManagement_System.DTO.RequestDTO.DirectorRequestDTO;
import com.example.LibraryManagement_System.Entities.Director;

public interface DirectorService {
    public String addDirector(DirectorRequestDTO directorRequestDTO);
}
