package com.mylibrary.controller;

import com.mylibrary.model.Book;
import com.mylibrary.repository.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
@CrossOrigin(origins="http://localhost:3000")
public class BookController {

    @Autowired
    private IBook bookRepository;

//    @PostMapping("/book")
//    Book newBook(@RequestBody Book newBook) {
//        return bookRepository.save(newBook);
//    }
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
    Book savedBook = bookRepository.save(newBook);
    return new ResponseEntity<>(savedBook, HttpStatus.OK);
}

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book updatedBook) {
        Book existingBook = bookRepository.getById(updatedBook.getCodISBN());
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setEditura(updatedBook.getEditura());
            bookRepository.deleteById(existingBook.getCodISBN());
            Book updatedBook1 = bookRepository.save(existingBook);
            return new ResponseEntity<>(updatedBook1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books")
    List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    Book getBookById(@PathVariable Integer id) {
        return bookRepository.getById(id);
    }

//    @PutMapping("/book/{id}")
//    Book updateBook(@RequestBody Book newBook, @PathVariable Integer id) {
//        Book u = bookRepository.getById(id);
//        u.setTitle(newBook.getTitle());
//        u.setAuthor(newBook.getAuthor());
//        u.setEditura(newBook.getEditura());
//        return u;
//    }
@DeleteMapping("/book/{id}")
Integer deleteBook(@PathVariable Integer id) throws Exception {
    if (!bookRepository.existsById(id)) {
        throw new Exception("Nu exista user");
    }
    bookRepository.deleteById(id);
    return id;
}

}
