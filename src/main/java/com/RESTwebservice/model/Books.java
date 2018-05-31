package com.RESTwebservice.model;

public class Books {
 private Integer barcode;
 private String title;
 private String author;
 private String readornot;
 private int numberofpages;
 
 public Books() {
  super();
 }
 
 public Books(Integer id) {
  super();
  barcode = id;
 }

 public Integer getbarcode() {
  return barcode;
 }
 public void setbarcode(Integer barcode) {
  this.barcode = barcode;
 }
 public String gettitle() {
  return title;
 }
 public void settitle(String title) {
  this.title = title;
 }
 public String getauthor() {
  return author;
 }
 public void setauthor(String author) {
  this.author = author;
 }
 public int getnumberofpages() {
  return numberofpages;
 }
 public void setnumberofpages(int numberofpages) {
  this.numberofpages = numberofpages;
 }
 public String getreadornot() {
	 return readornot;
 }
 public void setreadornot(String readornot)
 {
	 this.readornot=readornot;
 }
}