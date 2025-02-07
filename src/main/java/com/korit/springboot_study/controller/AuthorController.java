package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqAddAuthorDto;
import com.korit.springboot_study.dto.request.ReqAddCategoryDto;
import com.korit.springboot_study.dto.request.ReqSearchAuthorDto;
import com.korit.springboot_study.dto.request.ReqSearchCategoryDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Category;
import com.korit.springboot_study.service.AuthorService;
import com.korit.springboot_study.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Author API")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @ApiOperation(value = "도서 저자 추가")
    @PostMapping("/api/author")
    public ResponseEntity<SuccessResponseDto<Author>> addAuthor(@Valid @RequestBody ReqAddAuthorDto reqAddAuthorDto)  {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(authorService.addAuthor(reqAddAuthorDto)));
    }

    @ApiOperation(value = "저자 검색")
    @GetMapping("/api/author")
    public ResponseEntity<SuccessResponseDto<List<Author>>> searchAuthor (@ModelAttribute ReqSearchAuthorDto reqSearchAuthorDto) throws Exception {
        System.out.println(reqSearchAuthorDto);
        return ResponseEntity.ok().body(new SuccessResponseDto<>(authorService.getAuthor(reqSearchAuthorDto)));
    }
}
