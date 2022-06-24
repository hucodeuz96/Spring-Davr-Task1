package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Teacher;
import com.example.springdavrtask.hucode.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/teacher")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @PostMapping
    public ApiResponse<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher save = teacherRepository.save(teacher);
        return new ApiResponse<>("Saved Succesfully", true, save);
    }

    @GetMapping("/all")
    public ApiResponse<List<Teacher>> getAll() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return new ApiResponse<>("all", true, teacherList);
    }

    @GetMapping("/{id}")
    public ApiResponse<Teacher> getOne(@PathVariable Long id) {
        Optional<Teacher> repositoryById = teacherRepository.findById(id);
        if (repositoryById.isPresent()) {
            Teacher teacher = repositoryById.get();
            return new ApiResponse<>("Successfully", true, teacher);
        } else {
            return new ApiResponse<>("Id not found", true, null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher teacherOld = teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("teacher not found"));
        teacherOld.setFullName(teacher.getFullName());
        teacherOld.setPhone(teacher.getPhone());
        teacherOld.setSalary(teacher.getSalary());
        Teacher save = teacherRepository.save(teacherOld);
        return new ApiResponse<>("Successfully", true, save);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        teacherRepository.deleteById(id);
        return new ApiResponse<>("Deleted", true, id);
    }
}
