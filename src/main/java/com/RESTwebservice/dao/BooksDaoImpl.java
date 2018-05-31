package com.RESTwebservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.RESTwebservice.model.Books;

@Repository
public class BooksDaoImpl implements BooksDao {
 
 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 
 @Autowired
 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
 }

 public List listAllbooks() {
  List list = new ArrayList();
  
  String sql = "SELECT barcode, title,author, numberofpages,readornot FROM books";
  
  list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new BooksMapper());
  
  return list;
 }
 
 private SqlParameterSource getSqlParameterByModel(Books book){
  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
  if(book != null){
   parameterSource.addValue("barcode", book.getbarcode());
   parameterSource.addValue("title", book.gettitle());
   parameterSource.addValue("author", book.getauthor());
   parameterSource.addValue("numberofpages", book.getnumberofpages());
   parameterSource.addValue("readornot",book.getreadornot());
  }
  return parameterSource;
 }
 
 private static final class BooksMapper implements RowMapper{

  public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
   Books book = new Books();
   book.setbarcode(rs.getInt("barcode"));
   book.settitle(rs.getString("title"));
   book.setauthor(rs.getString("author"));
   book.setnumberofpages(rs.getInt("numberofpages"));
   book.setreadornot(rs.getString("readornot"));
   return book;
  }
  
 }

 public void addBook(Books book) {
  String sql = "INSERT INTO books(barcode,title,author,numberofpages,author) VALUES(:barcode,:title,:author,:numberofpages,:author)";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(book));
 }

 public void updateBook(Books book) {
  String sql = "UPDATE books SET barcode=:barcode, title=:title, author=:author WHERE barcode =:barcode";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(book));
 }

 public void delete(Books book) {
  String sql = "DELETE FROM books WHERE barcode=:barcode";
  
  namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(book));
 }

 public Books findbookbybarcode(Books book) {
  String sql = "SELECT * FROM books WHERE barcode =:barcode";
  
  return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(book), new BooksMapper());
 }

}