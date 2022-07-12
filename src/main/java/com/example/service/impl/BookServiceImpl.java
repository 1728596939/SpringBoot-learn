package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.IBookServiece;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  extends ServiceImpl<BookDao, Book> implements IBookServiece   {
    @Autowired
    BookDao bookDao;


    //非条件查询，弃用
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
     IPage page = new Page(currentPage,pageSize);
      page= bookDao.selectPage(page,null);
        return page;
    }

    //条件分页查询
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize,Book book) {
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<Book>();
        qw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType())
                .like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName())
                .like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page = new Page(currentPage,pageSize);
        page= bookDao.selectPage(page,qw);
        return page;
    }
}
