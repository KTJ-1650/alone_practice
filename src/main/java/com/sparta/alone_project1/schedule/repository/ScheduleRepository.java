package com.sparta.alone_project1.schedule.repository;

import com.sparta.alone_project1.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
