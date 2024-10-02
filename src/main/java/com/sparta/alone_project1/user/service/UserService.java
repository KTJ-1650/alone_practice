package com.sparta.alone_project1.user.service;

import com.sparta.alone_project1.user.dto.UserRequestDto;
import com.sparta.alone_project1.user.dto.UserResponseDto;
import com.sparta.alone_project1.user.entity.User;
import com.sparta.alone_project1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);

    }

    public UserResponseDto inquiryUser(Long userId) {

       User user= userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("아이디가 존재하지 않습니다"));

       return new UserResponseDto(user);
    }

    public List<UserResponseDto> fullInquiryUser() {

       List<User> userList = userRepository.findAll();

       return userList.stream().map(UserResponseDto::new).toList();
    }

    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("아이디가 없대"));

        userRepository.delete(user);
    }
}
