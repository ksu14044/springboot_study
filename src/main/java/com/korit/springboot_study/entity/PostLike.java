package com.korit.springboot_study.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostLike {
    private int postLikeId;
    private int postId;
    private int userId;
    private LocalDateTime createdAt;

    private int likeCount;
}
