package com.example.LibraryManagement_System.Repositories;

import com.example.LibraryManagement_System.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
