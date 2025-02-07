package com.korit.springboot_study.service;


import com.korit.springboot_study.dto.request.ReqAddBookDTO;
import com.korit.springboot_study.dto.request.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.ReqFindBookDTO;
import com.korit.springboot_study.dto.request.ReqSearchCategoryDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.repository.BookRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

   @Autowired
   BookRepository bookRepository;

   public SuccessResponseDto<List<Book>> getBookByName(ReqFindBookDTO reqFindBookDTO) throws NotFoundException {
       System.out.println("서비스 호출");
       List<Book> foundBooks = bookRepository.findBookByName(new Book(0, reqFindBookDTO.getBookName(),0,"",0,0,"")).orElseThrow(() -> new NotFoundException("도서정보가 존재하지 않습니다."));

       return new SuccessResponseDto<>(foundBooks);
   }
   
   public SuccessResponseDto<Optional<Book>> addBook(ReqAddBookDTO reqAddBookDTO) {
     return new SuccessResponseDto<>(
             bookRepository.addBook(new Book(0, reqAddBookDTO.getBookName(), reqAddBookDTO.getAuthorId(), reqAddBookDTO.getIsbn(), reqAddBookDTO.getCategoryId(),reqAddBookDTO.getPublisherId(), reqAddBookDTO.getBookImgUrl()))
     );
   }



}
