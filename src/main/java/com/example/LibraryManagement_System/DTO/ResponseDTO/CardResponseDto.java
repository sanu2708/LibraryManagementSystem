package com.example.LibraryManagement_System.DTO.ResponseDTO;

import com.example.LibraryManagement_System.Enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class CardResponseDto {
    private int id;
    Date issueDate;
    private CardStatus cardStatus;
    private String validTill;
}
