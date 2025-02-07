package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddAuthorDto;
import com.korit.springboot_study.dto.request.ReqAddPublisherDto;
import com.korit.springboot_study.dto.request.ReqSearchAuthorDto;
import com.korit.springboot_study.dto.request.ReqSearchPublisherDto;
import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.repository.AuthorRepository;
import com.korit.springboot_study.repository.PublisherRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher addPublisher(ReqAddPublisherDto reqAddPublisherDto) {
        return publisherRepository.addPublisher(reqAddPublisherDto.toPublisher()).get();
    }

    public List<Publisher> getPublisher(ReqSearchPublisherDto reqSearchPublisherDto) throws Exception {
        return publisherRepository.findPublisherByNameContaining(reqSearchPublisherDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 카테고리가 없습니다."));
    }
}
