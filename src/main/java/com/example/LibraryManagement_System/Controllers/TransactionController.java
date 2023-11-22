package com.example.LibraryManagement_System.Controllers;

import com.example.LibraryManagement_System.DTO.RequestDTO.BookIssueReqDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.BookIssueResDto;
import com.example.LibraryManagement_System.Services.BookService;
import com.example.LibraryManagement_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/add")
    public BookIssueResDto issueBook(@RequestBody BookIssueReqDto bookIssueReqDto) throws Exception {
        return transactionService.issueBook(bookIssueReqDto);
    }
}
