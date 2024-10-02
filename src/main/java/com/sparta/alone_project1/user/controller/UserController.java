package com.sparta.alone_project1.user.controller;

import com.sparta.alone_project1.user.dto.UserRequestDto;
import com.sparta.alone_project1.user.dto.UserResponseDto;
import com.sparta.alone_project1.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){

        return userService.createUser(userRequestDto);
    }

    @GetMapping("/{userId}")
    public UserResponseDto inquiryUser(@PathVariable Long userId){

        return userService.inquiryUser(userId);
    }

    @GetMapping
    public List<UserResponseDto> fullInquiryUser(){

        return userService.fullInquiryUser();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){

        userService.deleteUser(userId);
    }



}
