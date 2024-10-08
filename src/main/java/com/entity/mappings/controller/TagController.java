package com.entity.mappings.controller;

import com.entity.mappings.model.Tag;
import com.entity.mappings.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    public ResponseEntity<?> getAllTags(){
        return ResponseEntity.ok(tagService.getAllTags());
    }

    public ResponseEntity<?> createTag(@RequestBody Tag tag){
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.createTag(tag));
    }

}
