package com.RESTwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RESTwebservice.dao.BooksDao;
import com.RESTwebservice.model.Books;

@Service
public  class BooksServiceImpl implements BooksService {
 
 BooksDao bookDao;
 
 @Autowired
 public void setbookDao(BooksDao bookDao) {
  this.bookDao = bookDao;
 }

 
 public void addBook(Books book) {
  bookDao.addBook(book);
 }

 public void updateBook(Books book) {
  bookDao.updateBook(book);
 }

 public void delete(Books book) {
  bookDao.delete(book);
 }

 public Books findbookbybarcode(Books book) {
  return bookDao.findbookbybarcode(book);
 }

public List listAllBooks() {
	// TODO Auto-generated method stub
	return null;
}

}