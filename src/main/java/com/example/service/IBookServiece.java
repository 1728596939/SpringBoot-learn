package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

public interface IBookServiece extends IService<Book> {

    IPage<Book> getPage(int currentPage ,int pageSize);
    IPage<Book> getPage(int currentPage ,int pageSize,Book book);
}
