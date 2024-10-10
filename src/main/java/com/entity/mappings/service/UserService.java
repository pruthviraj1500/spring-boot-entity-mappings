package com.entity.mappings.service;

import com.entity.mappings.dto.UserWithPostDto;
import com.entity.mappings.model.User;
import com.entity.mappings.repository.UserRepository;
import com.entity.mappings.response.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        List<User> users =  userRepository.findAll();

        return  users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setUser_id(user.getId());
            userResponse.setName(user.getName());
            return  userResponse;
        }).collect(Collectors.toList());
    }

    public List<UserWithPostDto> getUsersWithPosts(){
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            UserWithPostDto dto = new UserWithPostDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setPosts(user.getPosts());
            return dto;
        }).collect(Collectors.toList());

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public String removeUser(Long id){
        userRepository.deleteById(id);
        return "User removed with given id "+id;
    }

}
