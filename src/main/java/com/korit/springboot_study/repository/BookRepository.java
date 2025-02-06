package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookMapper bookMapper;

    public Optional<List<Book>> findBookByName(Book book) {
        System.out.println("레퍼지토리 호출");
        List<Book> foundBooks = bookMapper.getBookByName(book);

        return foundBooks.isEmpty()
                ? Optional.empty()
                : Optional.of(foundBooks);
    }

    public Optional<Book> addBook(Book book) {
        bookMapper.addBook(book);
        return Optional.ofNullable(new Book(book.getBookId(), book.getBookName(), book.getAuthorId(), book.getPublisherId()));
    }
}
