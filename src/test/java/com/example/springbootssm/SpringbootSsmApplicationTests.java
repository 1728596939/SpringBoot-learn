package com.example.springbootssm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.BookDao;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootSsmApplicationTests {

    @Autowired
    BookDao bookdao;
    @Test
    void contextLoads() {

        Book byId = bookdao.selectById(2);
        System.out.println(byId);
    }

    @Test
    void selectpagetest() {

        IPage iPage =new Page(2,5);
        IPage iPage1 = bookdao.selectPage(iPage, null);
        System.out.println(iPage1.getRecords());

    }



    @Test
    public void selectByCondition(){
        //条件查询

        String name=null;
        LambdaQueryWrapper<Book>  lqw=  new LambdaQueryWrapper<Book>();
        lqw.like( name!=null,Book::getName,"Spring");//替代if判断语句
        List<Book> books = bookdao.selectList(lqw);
        System.out.println(books);


    }


}
