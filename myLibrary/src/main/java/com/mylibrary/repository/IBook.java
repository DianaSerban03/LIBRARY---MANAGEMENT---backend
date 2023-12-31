package com.mylibrary.repository;


import com.mylibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IBook extends JpaRepository<Book, Integer> {
}
