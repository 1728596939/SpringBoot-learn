package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyBookServiceImpl implements MyBookService {

    @Autowired
     private BookDao bookdao;
    @Override
    public Book getById(Integer id) {
        return bookdao.selectById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookdao.deleteById(id)>0;
    }

    @Override
    public boolean updata(Book book) {
        return bookdao.updateById(book)>0;
    }

    @Override
    public boolean save(Book book) {
        return bookdao.insert(book)>0;
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }
}
