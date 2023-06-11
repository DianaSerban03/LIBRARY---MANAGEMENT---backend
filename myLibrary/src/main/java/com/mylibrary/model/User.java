package com.mylibrary.model;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")
public class User{
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name= "phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private UserRole role;

    @Transient
    private List<Book> rentedBooks;


    public User(String username, String password, String firstName, String lastName, String email, String phoneNumber, UserRole role, List<Book> rentedBooks) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.rentedBooks = rentedBooks;
    }

    public User() {}

    public List<Book> getRentedBooks() {
        if (rentedBooks == null) {
            return new ArrayList<>(); // sau Collections.emptyList() pentru o listă imutabilă
        }
        return rentedBooks;
    }


    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
