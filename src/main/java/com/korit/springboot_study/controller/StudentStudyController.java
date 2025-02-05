package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.response.common.ResponseDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import com.korit.springboot_study.service.StudentStudyService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentStudyController {

    @Autowired
    private StudentStudyService studentStudyService;


    @GetMapping("api/study/majors")
    @ApiOperation(value = "학과 전체 조회")
    public ResponseEntity<SuccessResponseDto<List<Major>>> getMajors() throws NotFoundException {

        return ResponseEntity.ok().body(studentStudyService.getMajorsAll());
    }

    @GetMapping("api/study/instructors")
    @ApiOperation(value = "교수 전체 조회")

    public ResponseEntity<SuccessResponseDto<List<Instructor>>> getInstructors() throws NotFoundException {
        return ResponseEntity.ok().body(studentStudyService.getInstructorsAll());
    }
}
