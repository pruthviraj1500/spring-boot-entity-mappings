package com.entity.mappings.service;

import com.entity.mappings.custom_exception_handling.ResourceNotFoundException;
import com.entity.mappings.dto.CreatePostDTO;
import com.entity.mappings.model.Post;
import com.entity.mappings.model.User;
import com.entity.mappings.repository.PostRepository;
import com.entity.mappings.repository.UserRepository;
import com.entity.mappings.response.PostResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public PostResponse createPostForSpecificUser(CreatePostDTO createPostDTO) {

        User user = userRepository.findById(createPostDTO.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Post post = new Post();
        post.setContent(createPostDTO.getContent());
        //post.setUser(user);

        Post savedPost =  postRepository.save(post);

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(savedPost.getContent());
        postResponse.setUser_id(user.getId());

        return postResponse;
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

}
