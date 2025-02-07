package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddAuthorDto;
import com.korit.springboot_study.dto.request.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.ReqSearchAuthorDto;
import com.korit.springboot_study.dto.request.ReqSearchCategoryDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.repository.AuthorRepository;
import com.korit.springboot_study.repository.CategoryRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author addAuthor(ReqAddAuthorDto reqAddAuthorDto){
        return authorRepository.addAuthor(reqAddAuthorDto.toAuthor()).get();
    }

    public List<Author> getAuthor(ReqSearchAuthorDto reqSearchAuthorDto) throws Exception {
        return authorRepository.findAuthorByNameContaining(reqSearchAuthorDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 카테고리가 없습니다."));
    }
}
