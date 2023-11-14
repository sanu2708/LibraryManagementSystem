package com.example.LibraryManagement_System.Services;

import com.example.LibraryManagement_System.DTO.RequestDTO.StudentRequestDto;
import com.example.LibraryManagement_System.DTO.RequestDTO.StudentUpdateMobNoReqDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.StudentUpdateMobNoResDto;
import com.example.LibraryManagement_System.Exceptions.idNotFound;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(int id);

    public StudentUpdateMobNoResDto updateMobNo(StudentUpdateMobNoReqDto studentUpdateMobNoReqDto) throws idNotFound;

}
