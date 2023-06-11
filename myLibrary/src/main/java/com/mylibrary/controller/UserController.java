package com.mylibrary.controller;


import com.mylibrary.model.Book;
import com.mylibrary.model.User;
import com.mylibrary.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private IUser userRepository;

    @PostMapping("/user")
    public ResponseEntity<User> addBook(@RequestBody User newBook) {
        User savedBook = userRepository.save(newBook);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable String id) {
        return userRepository.findByUsername(id);
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable String id) {
        User u = userRepository.getById(id);
        u.setFirstName(newUser.getFirstName());
        u.setEmail(newUser.getEmail());
        u.setPassword(newUser.getPassword());
        u.setLastName(newUser.getLastName());
        u.setPhoneNumber(newUser.getPhoneNumber());
        u.setRole(newUser.getRole());
        return u;
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable String id) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("Nu exista user");
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }


    @GetMapping("/rentedbooks/{id}")
    public List<Book> getRentedBooks(@PathVariable String id) {
        User user = userRepository.findByUsername(id);
        user.getRentedBooks().add(new Book(10, "z", "z", "z"));
        return user.getRentedBooks();
    }


    @PostMapping("/addbook/{id}")
    public ResponseEntity<Book> addRentedBook(@PathVariable String id, @RequestBody Book newUser) {
        User user = userRepository.findByUsername(id);
        //List<Book> rented = user.getRentedBooks();
        //rented.add(newUser);
        user.getRentedBooks().add(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @DeleteMapping("/deletebook/{id}/{username}")
    Integer deleteRentedBook(@PathVariable Integer id,  @PathVariable String username) throws Exception {
        User user = userRepository.findByUsername(username);
        List<Book> rented = user.getRentedBooks();
        Book found = new Book();
        for (Book b: rented)
            if (b.getCodISBN()==id) found = b;
        rented.remove(found);
        return found.getCodISBN();
    }


}