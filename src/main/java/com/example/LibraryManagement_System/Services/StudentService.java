package com.example.LibraryManagement_System.Services;

import com.example.LibraryManagement_System.DTO.RequestDTO.StudentRequestDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagement_System.Entities.Student;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int id);

}
