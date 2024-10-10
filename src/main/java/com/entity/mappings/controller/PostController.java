package com.entity.mappings.controller;

import com.entity.mappings.dto.CreatePostDTO;
import com.entity.mappings.model.Post;
import com.entity.mappings.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/specific-user")
    public ResponseEntity<?> createPostForSpecificUser(@RequestBody CreatePostDTO createPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPostForSpecificUser(createPostDTO));
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(post));
    }

}
