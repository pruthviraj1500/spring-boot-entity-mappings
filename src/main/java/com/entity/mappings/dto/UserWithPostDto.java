package com.entity.mappings.dto;

import com.entity.mappings.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPostDto {

    private Long id;
    private String name;
    private List<Post> posts;

}
