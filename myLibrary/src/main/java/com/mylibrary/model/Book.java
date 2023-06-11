package com.mylibrary.model;


import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codISBN;
    private String title;
    private String author;
    private String editura;

    public Book(){};

    public Book(int codISBN, String title, String author, String editura) {
        this.codISBN = codISBN;
        this.title = title;
        this.author = author;
        this.editura = editura;
    }

    public int getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(int codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titile) {
        this.title = titile;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }
}
