package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.study.Instructor;
import com.korit.springboot_study.entity.study.Major;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.exception.CustomNullPointException;
import com.korit.springboot_study.mapper.StudentStudyMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentStudyRepository {
    @Autowired
    private StudentStudyMapper studentStudyMapper;

    public Optional<List<Major>> findMajorAll() {
        List<Major> foundMajors = studentStudyMapper.selectMajorsAll();

        return foundMajors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundMajors);
    }

    public Optional<List<Instructor>> findInstructorAll() {
        List<Instructor> foundInstructors = studentStudyMapper.selectInstructorsAll();

        return foundInstructors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundInstructors);
    }

    public Optional<Major> saveMajor(Major major) throws DuplicateKeyException {
        try {
            studentStudyMapper.insertMajor(major);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("majorName", "이미 존재하는 학과명입니다."));
        }
        return Optional.ofNullable(new Major(major.getMajorId(), major.getMajorName()));
    }

    public Optional<Instructor> saveInstructor(Instructor instructor) {
        try {
            studentStudyMapper.insertInstructor(instructor);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(
                    e.getMessage(),
                    Map.of("instructorName", "이미 존재하는 교수명입니다.")
            );
        }
            return Optional.ofNullable(new Instructor(instructor.getInstructorId(), instructor.getInstructorName()));
    }

    public Optional<Major> updateMajor(int majorId, Major major) {
        try{
            studentStudyMapper.updateMajor(major);
        } catch (NullPointerException e) {
            throw new CustomNullPointException(
                    e.getMessage(),
                    Map.of("majorName", "학과명을 입력하세요.")
            );
        }
            return Optional.ofNullable(new Major(majorId, major.getMajorName()));
    }
}

