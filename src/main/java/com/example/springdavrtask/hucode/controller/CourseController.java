package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.repository.CourseRepository;
import com.example.springdavrtask.hucode.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/course")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public HttpEntity<?> saveCourse(@RequestBody Course course) {
        ApiResponse<Course> apiResponse = courseService.save(course);
        return ResponseEntity.status(apiResponse.isSuccess()
                ?HttpStatus.CREATED
                :HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        ApiResponse<Course> apiResponse = courseService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 :404).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course course) {
        ApiResponse<Course> update = courseService.update(id, course);
        return ResponseEntity.status(update.isSuccess() ? 200 : 404).body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ApiResponse<String> apiResponse = courseService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 :404).body(apiResponse);
    }
}
