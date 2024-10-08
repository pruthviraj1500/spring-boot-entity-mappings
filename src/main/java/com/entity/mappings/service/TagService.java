package com.entity.mappings.service;

import com.entity.mappings.model.Tag;
import com.entity.mappings.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

}
