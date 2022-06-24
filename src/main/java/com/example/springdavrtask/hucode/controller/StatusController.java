package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Status;
import com.example.springdavrtask.hucode.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/status")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class StatusController {
    private final StatusRepository statusRepository;

    @PostMapping
    public ApiResponse<Status> saveStatus(@RequestBody Status status) {
        Status save = statusRepository.save(status);
        return new ApiResponse<>("Saved Succesfully", true, save);
    }

    @GetMapping("/all")
    public ApiResponse<List<Status>> getAll() {
        List<Status> statusList = statusRepository.findAll();
        return new ApiResponse<>("all", true, statusList);
    }

    @GetMapping("/{id}")
    public ApiResponse<Status> getOne(@PathVariable Long id) {
        Optional<Status> repositoryById = statusRepository.findById(id);
        if (repositoryById.isPresent()) {
            Status status = repositoryById.get();
            return new ApiResponse<>("Successfully", true, status);
        } else {
            return new ApiResponse<>("Id not found", true, null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<Status> update(@PathVariable Long id, @RequestBody Status status) {
        Status statusOld = statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("status not found"));

        Status save = statusRepository.save(statusOld);
        return new ApiResponse<>("Successfully", true, save);
    }
    @DeleteMapping("/{id}")
    public ApiResponse<Long> delete(@PathVariable Long id) {
        statusRepository.deleteById(id);
        return new ApiResponse<>("Deleted", true, id);
    }
}
