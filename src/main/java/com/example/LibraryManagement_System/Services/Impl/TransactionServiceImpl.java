package com.example.LibraryManagement_System.Services.Impl;

import com.example.LibraryManagement_System.DTO.RequestDTO.BookIssueReqDto;
import com.example.LibraryManagement_System.DTO.ResponseDTO.BookIssueResDto;
import com.example.LibraryManagement_System.Entities.Book;
import com.example.LibraryManagement_System.Entities.Card;
import com.example.LibraryManagement_System.Entities.Transaction;
import com.example.LibraryManagement_System.Enums.CardStatus;
import com.example.LibraryManagement_System.Enums.TransactionStatus;
import com.example.LibraryManagement_System.Repositories.BookRepository;
import com.example.LibraryManagement_System.Repositories.CardRepository;
import com.example.LibraryManagement_System.Repositories.TransactionRepository;
import com.example.LibraryManagement_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Override
    public BookIssueResDto issueBook(BookIssueReqDto bookIssueReqDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIsIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(bookIssueReqDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card not found!!");
        }
        Book book;
        try{
            book = bookRepository.findById(bookIssueReqDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book not Found!!");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Your Card is not Activated!!");
        }
        if(book.getIsBookIssued())
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("This Book is Already issued!!");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIsBookIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);
        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);

        BookIssueResDto bookIssueResDto = new BookIssueResDto();
        bookIssueResDto.setBookName(book.getTitle());
        bookIssueResDto.setTransactionNumber(transaction.getTransactionNumber());
        bookIssueResDto.setTransactionStatus(transaction.getTransactionStatus());
        return bookIssueResDto;
    }
}
