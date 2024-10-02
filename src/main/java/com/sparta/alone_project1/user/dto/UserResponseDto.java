package com.sparta.alone_project1.user.dto;

import com.sparta.alone_project1.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String username;
    private String email;

    public UserResponseDto(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
