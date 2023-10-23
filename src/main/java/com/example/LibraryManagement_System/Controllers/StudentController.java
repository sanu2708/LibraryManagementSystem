package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.DTO.RequestDTO.StudentRequestDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagement_System.Entities.Student;
import com.example.LibraryManagement_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/get")
    public StudentResponseDto getStudentById(@RequestParam("id") Integer id)
    {
        return studentService.getStudentById(id);
    }

}
