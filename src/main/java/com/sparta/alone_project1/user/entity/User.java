package com.sparta.alone_project1.user.entity;

import com.sparta.alone_project1.config.TimeStamp;
import com.sparta.alone_project1.user.dto.UserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;

    public User(UserRequestDto userRequestDto){
        this.username = userRequestDto.getUsername();
        this.email = userRequestDto.getEmail();
    }

}
