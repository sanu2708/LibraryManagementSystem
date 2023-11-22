package com.example.LibraryManagement_System.DTO.ResponseDTO;

import com.example.LibraryManagement_System.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookIssueResDto {
    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;

}
