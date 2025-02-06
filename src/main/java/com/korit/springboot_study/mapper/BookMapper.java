package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getBookByName(Book book);

    int addBook(Book book);
}
