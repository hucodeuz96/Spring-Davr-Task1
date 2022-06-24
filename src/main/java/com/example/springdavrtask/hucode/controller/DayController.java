package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Day;
import com.example.springdavrtask.hucode.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/day")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class DayController {
    private final DayRepository dayRepository;

    @PostMapping
    public ApiResponse<Day> saveDay(@RequestBody Day day) {
        Day save = dayRepository.save(day);
        return new ApiResponse<>("Saved Succesfully", true, save);
    }

    @GetMapping("/all")
    public ApiResponse<List<Day>> getAll() {
        List<Day> dayList = dayRepository.findAll();
        return new ApiResponse<>("all", true, dayList);
    }

    @GetMapping("/{id}")
    public ApiResponse<Day> getOne(@PathVariable Long id) {
        Optional<Day> repositoryById = dayRepository.findById(id);
        if (repositoryById.isPresent()) {
            Day day = repositoryById.get();
            return new ApiResponse<>("Successfully", true, day);
        } else {
            return new ApiResponse<>("Id not found", true, null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<Day> update(@PathVariable Long id, @RequestBody Day day) {
        Day dayOld = dayRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("day not found"));
        dayOld.setName(day.getName());
        Day save = dayRepository.save(dayOld);
        return new ApiResponse<>("Successfully", true, save);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        dayRepository.deleteById(id);
        return new ApiResponse<>("Deleted", true, id);
    }
}
