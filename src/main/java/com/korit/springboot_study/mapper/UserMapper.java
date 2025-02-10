package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectByUsername(String username);
    int insert(User user);
    User selectById(int userId);
    List<User> selectAll();
    int updateUserById(User user);
    int deleteById(int userId);
}
