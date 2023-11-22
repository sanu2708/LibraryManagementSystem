package com.example.LibraryManagement_System.Services;

import com.example.LibraryManagement_System.DTO.RequestDTO.BookIssueReqDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.BookIssueResDto;

public interface TransactionService {
    public BookIssueResDto issueBook(BookIssueReqDto bookIssueReqDto) throws Exception;
}
