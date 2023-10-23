package com.example.LibraryManagement_System.DTO.ResponseDTO;

import com.example.LibraryManagement_System.Entities.Card;
import com.example.LibraryManagement_System.Enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentResponseDto {
    private int id;
    private String name;
    private int age;
    private Department department;
    private String mobNo;
    CardResponseDto cardResponseDto;
}
