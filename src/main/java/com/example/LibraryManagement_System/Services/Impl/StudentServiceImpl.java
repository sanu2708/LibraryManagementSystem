package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.StudentRequestDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.CardResponseDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagement_System.Entities.Card;
import com.example.LibraryManagement_System.Entities.Student;
import com.example.LibraryManagement_System.Enums.CardStatus;
import com.example.LibraryManagement_System.Repositories.StudentRepository;
import com.example.LibraryManagement_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setAge(studentRequestDto.getAge());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill(("2024-01-01"));
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added Successfully";

    }

    @Override
    public StudentResponseDto getStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }
}