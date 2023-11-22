package com.example.LibraryManagement_System.Repositories;

import com.example.LibraryManagement_System.Entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CardRepository extends JpaRepository <Card,Integer> {
}
