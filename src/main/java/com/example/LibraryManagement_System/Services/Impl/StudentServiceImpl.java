package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.StudentRequestDto;
import com.example.LibraryManagement_System.DTO.RequestDTO.StudentUpdateMobNoReqDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.CardResponseDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentUpdateMobNoResDto;
import com.example.LibraryManagement_System.Entities.Card;
import com.example.LibraryManagement_System.Entities.Student;
import com.example.LibraryManagement_System.Enums.CardStatus;
import com.example.LibraryManagement_System.Exceptions.idNotFound;
import com.example.LibraryManagement_System.Repositories.StudentRepository;
import com.example.LibraryManagement_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public StudentUpdateMobNoResDto updateMobNo(StudentUpdateMobNoReqDto studentUpdateMobNoReqDto) throws idNotFound {

        try{
            Student student = studentRepository.findById(studentUpdateMobNoReqDto.getId()).get();

            student.setMobNo(studentUpdateMobNoReqDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            StudentUpdateMobNoResDto updateStudentMobNoResDto = new StudentUpdateMobNoResDto();
            updateStudentMobNoResDto.setName(updatedStudent.getName());
            updateStudentMobNoResDto.setMobNo(updatedStudent.getMobNo());

            return updateStudentMobNoResDto;
        }
        catch (Exception e)
        {
            throw new idNotFound("StudentId not found");
        }
    }
}