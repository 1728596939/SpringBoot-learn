package com.example.springbootssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.IBookServiece;
import com.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {


    @Autowired
    private IBookServiece bookServiece;

    @Test
    public  void deleteByIdTest(){
        System.out.println(bookServiece.removeById(14));

    }

    @Test
    public  void getByIdTest(){
        System.out.println(bookServiece.getById(2));

    }

    @Test
    public  void getAllTest(){
        System.out.println(bookServiece.list());

    }

    @Test
    public  void saveTest(){

        Book book = new Book();
        book.setName("道德经");
        book.setDescription("老子写的");
        System.out.println(bookServiece.save(book));

    }

    @Test
    public  void updataTest(){

        Book book = new Book();
        book.setName("道德经");
        book.setDescription("老子写的");
        book.setId(1);
        System.out.println(bookServiece.updateById(book));

    }

    @Test
    void getPageTest(){
        IPage<Book> bookIPage = new Page<Book>(2,5);
        IPage<Book> page = bookServiece.page(bookIPage);
        System.out.println(page.getRecords());

    }
}
