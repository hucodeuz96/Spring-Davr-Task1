package com.example.springdavrtask.hucode.service;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.excaption.NotFoundException;
import com.example.springdavrtask.hucode.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 6:37 PM on 6/24/2022
 * @project Spring-Davr-Task
 */
@Service
@RequiredArgsConstructor
public class CourseService {

    private  final CourseRepository courseRepository;


    public ApiResponse<Course> save(Course course){
        return new ApiResponse<>("saved",true,courseRepository.save(course));
    }
    public ApiResponse<Course> update(Long id,Course course){
        Course courseOld = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course not found"));
        courseOld.setName(course.getName());
        courseOld.setDuration(course.getDuration());
        courseOld.setPrice(course.getPrice());
        return new ApiResponse<>("updated",true,courseRepository.save(courseOld));
    }
    public ApiResponse<List<Course>> getAll(){
        return new ApiResponse<>("getAll",true,courseRepository.findAll());
    }
    public ApiResponse<Course> getOne(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new NotFoundException("course not found"));

        return new ApiResponse<>("getOne",true,course);
    }
    public ApiResponse<String> delete(Long id){
        courseRepository.deleteById(id);
        return new ApiResponse<>("deleted",true,"ok");
    }



}
