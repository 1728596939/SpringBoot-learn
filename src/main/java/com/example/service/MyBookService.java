package com.example.service;

import com.example.domain.Book;

import java.util.List;

public interface MyBookService {
  Book getById(Integer id);
    boolean deleteById(Integer id);
    boolean updata(Book book);
    boolean save(Book book);
    List<Book> getAll();




}
