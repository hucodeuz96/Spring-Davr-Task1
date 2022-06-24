package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Student;

import com.example.springdavrtask.hucode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/student")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class StudentController {
    private final StudentRepository studentRepository;

    @PostMapping
    public ApiResponse<Student> saveStudent(@RequestBody Student student) {
        Student save = studentRepository.save(student);
        return new ApiResponse<>("Saved Succesfully", true, save);
    }

    @GetMapping("/all")
    public ApiResponse<List<Student>> getAll() {
        List<Student> studentList = studentRepository.findAll();
        return new ApiResponse<>("all", true, studentList);
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> getOne(@PathVariable Long id) {
        Optional<Student> repositoryById = studentRepository.findById(id);
        if (repositoryById.isPresent()) {
            Student student = repositoryById.get();
            return new ApiResponse<>("Successfully", true, student);
        } else {
            return new ApiResponse<>("Id not found", true, null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Student studentOld = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found"));
        studentOld.setFullName(student.getFullName());
        studentOld.setPhone(student.getPhone());
        Student save = studentRepository.save(studentOld);
        return new ApiResponse<>("Successfully", true, save);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return new ApiResponse<>("Deleted", true, id);
    }
}
