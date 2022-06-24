package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.dto.ResTimeTableDto;
import com.example.springdavrtask.hucode.dto.TimeTableDto;
import com.example.springdavrtask.hucode.entity.TimeTable;
import com.example.springdavrtask.hucode.repository.TimeTableRepository;
import com.example.springdavrtask.hucode.service.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/timeTable")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class TimeTableController {
    private final TimeTableRepository timeTableRepository;
    private final TimeTableService timeTableService;

    @PostMapping
    public ApiResponse<ResTimeTableDto> saveTimeTable(@RequestBody TimeTableDto timeTableDto) {
        ResTimeTableDto resTimeTableDto = timeTableService.addTime(timeTableDto);
        return new ApiResponse<>("Saved Successfully", true, resTimeTableDto);
    }

    @GetMapping("/all")
    public ApiResponse<List<ResTimeTableDto>> getAll() {
        return new ApiResponse<>("all", true, timeTableService.getAll());
    }


    @GetMapping("/{id}")
    public ApiResponse<ResTimeTableDto> getOne(@PathVariable Long id) {
        return new ApiResponse<>("Successfully", true, timeTableService.get(id));
    }


    @PutMapping("/{id}")
    public ApiResponse<ResTimeTableDto> update(@PathVariable Long id, @RequestBody TimeTableDto dto) {
        ResTimeTableDto update = timeTableService.update(id, dto);
        return new ApiResponse<>("Successfully", true, update);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        timeTableRepository.deleteById(id);
        return new ApiResponse<>("Deleted", true, id);
    }
}
