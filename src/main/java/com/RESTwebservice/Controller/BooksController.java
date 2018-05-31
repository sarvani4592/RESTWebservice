package com.RESTwebservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.RESTwebservice.model.Books;

import com.RESTwebservice.service.BooksService;

@RestController
public class BooksController {
 
 @Autowired
 BooksService bookService;
 
 @RequestMapping(value="/user/", method = RequestMethod.GET, headers="Accept=application/json")
 public ResponseEntity<List<Books>> listAllBooks(){
  List<Books> list = bookService.listAllBooks();
  
  if(list.size() == 0){
   return new ResponseEntity<List<Books>>(HttpStatus.NO_CONTENT);
  }
  
  return new ResponseEntity<List<Books>>(list, HttpStatus.OK);
 }
 
 @RequestMapping(value="/add/", method = RequestMethod.POST, headers="Accept=application/json")
 public ResponseEntity<Void> add(@RequestBody Books book){
  bookService.addBook(book);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
 public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Books book){
  book.setbarcode(id);
  bookService.updateBook(book);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.OK);
 }
 
 @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
 public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Books book){
  book.setbarcode(id);
  bookService.delete(book);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
 }
}