package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Author;
import com.korit.springboot_study.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublisherMapper {

    List<Publisher> selectAllByNameContaining(@Param(value="publisherName") String publisherName);
    int addPublisher(Publisher publisher);
}
