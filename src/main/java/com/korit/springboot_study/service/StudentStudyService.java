package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.response.common.NotFoundResponseDto;
import com.korit.springboot_study.dto.response.common.ResponseDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.repository.StudentStudyRepository;
import com.sun.net.httpserver.Authenticator;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentStudyService {

    @Autowired
    private StudentStudyRepository studentStudyRepository;

    public SuccessResponseDto<List<Major>> getMajorsAll() throws NotFoundException {

        List<Major> foundMajors = studentStudyRepository.findMajorAll()
                .orElseThrow(() -> new NotFoundException("학과 데이터가 존재하지 않습니다."));

        return new SuccessResponseDto<>(foundMajors);
    }

    public SuccessResponseDto<List<Instructor>> getInstructorsAll() throws NotFoundException {
        List<Instructor> foundInstructors = studentStudyRepository.findInstructorAll()
                .orElseThrow(() -> new NotFoundException("교수 데이터가 존재하지 않습니다."));

        return new SuccessResponseDto<>(foundInstructors);
    }
}
