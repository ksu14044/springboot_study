package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddBookDTO;
import com.korit.springboot_study.dto.request.ReqFindBookDTO;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Book;
import com.korit.springboot_study.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    @ApiOperation(value = "도서 조회")
    public ResponseEntity<SuccessResponseDto<List<Book>>> getBooksByName(@RequestParam(required = false) String bookName) throws NotFoundException {
        System.out.println("컨트롤러 호출");
        ReqFindBookDTO reqFindBookDTO = new ReqFindBookDTO();
        reqFindBookDTO.setBookName(bookName);
        return ResponseEntity.ok().body(bookService.getBookByName(reqFindBookDTO));
    }
    
    @PostMapping("/api/books")
    public ResponseEntity<SuccessResponseDto<Optional<Book>>> addBook(@RequestBody @Valid ReqAddBookDTO reqAddBookDTO) throws MethodArgumentNotValidException {
        return ResponseEntity.ok().body(bookService.addBook(reqAddBookDTO));
    }
}
