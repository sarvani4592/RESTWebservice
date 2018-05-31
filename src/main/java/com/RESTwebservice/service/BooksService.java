package com.RESTwebservice.service;

import java.util.List;

import com.RESTwebservice.model.Books;

public interface BooksService {

public List listAllBooks();
 
 public void addBook(Books book);
 
 public void updateBook(Books book);
 
 public void delete(Books book);
 
 public Books findbookbybarcode(Books book);
}