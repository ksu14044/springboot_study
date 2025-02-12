package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.ReqCreatePostDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Post;
import com.korit.springboot_study.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Api(tags = "게시글 API")
public class PostController {

    @Autowired
    private PostService postService;

    //CREATE
    @PostMapping("/api/post")
    public ResponseEntity<SuccessResponseDto<Post>> createPost(@RequestBody ReqCreatePostDto reqCreatePostDto) {
        return ResponseEntity.created(URI.create("")).body(new SuccessResponseDto<>(postService.createPost(reqCreatePostDto)));
    }

    //READ(단건)
    @GetMapping("/api/post/{postId}")
    public ResponseEntity<SuccessResponseDto<Post>> getPost(@PathVariable int postId) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.getPostById(postId)));
    }

    //READ(다건)
    @GetMapping("/api/posts")
    public ResponseEntity<SuccessResponseDto<List<Post>>> getPosts(
            @RequestParam(required = true) int page,
            @RequestParam(required = true) int size,
            @RequestParam(required = false, defaultValue = "") String keyword
    ) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.getAllPostsByKeywordContaining(page, size, keyword)));
    }

    @PostMapping("/api/post/{postId}/like")
    public ResponseEntity<SuccessResponseDto<Boolean>> likePost(@PathVariable int postId) throws Exception {
        int userId = 2;
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.likePost(postId, userId)));
    }

    @DeleteMapping("/api/post/{postId}/like")
    public ResponseEntity<SuccessResponseDto<Post>> dislikePost(@PathVariable int postId) throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(null));
    }

}
