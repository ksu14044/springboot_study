package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.AuthorMapper;
import com.korit.springboot_study.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    @Autowired
    private AuthorMapper authorMapper;

    public Optional<Author> addAuthor(Author author) {
        try {
            System.out.println("addCategory 호출1");
            authorMapper.addAuthor(author);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException("이미 존재하는 카테고리명입니다.");
        }
        return Optional.of(author);
    }

    public Optional<List<Author>> findAuthorByNameContaining(String authorName) {
        System.out.println(authorName);
        return authorMapper.selectAllByNameContaining(authorName).isEmpty()
                ? Optional.empty()
                : Optional.of(authorMapper.selectAllByNameContaining(authorName));
    }
}
