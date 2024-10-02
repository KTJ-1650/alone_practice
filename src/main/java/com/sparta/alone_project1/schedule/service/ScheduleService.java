package com.sparta.alone_project1.schedule.service;

import com.sparta.alone_project1.schedule.dto.ScheduleRequestDto;
import com.sparta.alone_project1.schedule.dto.ScheduleResponseDto;
import com.sparta.alone_project1.schedule.entity.Schedule;
import com.sparta.alone_project1.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto creatSchedule(ScheduleRequestDto scheduleRequestDto) {

        Schedule schedule = new Schedule(scheduleRequestDto);

      Schedule savedSchedule = scheduleRepository.save(schedule);

      return new ScheduleResponseDto(savedSchedule);
    }

    public ScheduleResponseDto inquirySchedule(Long scheduleId) {

       Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new IllegalArgumentException("스케쥴 아이디가 존재하지 않습니다"));

       return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto) {

       Schedule foundSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new IllegalArgumentException("스케쥴 아이디가 존재하지 않습니다"));

       foundSchedule.updateSchedule(scheduleRequestDto);

       return new ScheduleResponseDto(foundSchedule);
    }

    public Page<ScheduleResponseDto> pageSchedule(int page, int size) {

        Pageable pageable = PageRequest.of(page -1,size);

        Page<Schedule> pagedSchedule = scheduleRepository.findAllByOrderByModifiedAtDesc(pageable);

       Page<ScheduleResponseDto> scheduleResponseDtos = pagedSchedule.map(schedule -> new ScheduleResponseDto(schedule));

       return scheduleResponseDtos;
    }


    public void deleteSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new IllegalArgumentException("스케쥴 아이디가 존재하지 않습니다"));

        scheduleRepository.delete(schedule);
    }
}
