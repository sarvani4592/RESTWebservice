package com.RESTwebservice.dao;

import java.util.List;

import com.RESTwebservice.model.Books;

public interface BooksDao {
 
 public List listAllbooks();
 
 public void addBook(Books book);
 
 public void updateBook(Books book);
 
 public void delete(Books book);
 
 public Books findbookbybarcode(Books book);
 
}
