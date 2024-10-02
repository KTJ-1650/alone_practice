package com.sparta.alone_project1.user.repository;

import com.sparta.alone_project1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
