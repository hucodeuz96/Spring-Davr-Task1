package com.example.springdavrtask.hucode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Husniddin Ulachov"
 * @created 4:57 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private String message;
    private boolean success;
    private T data;

}
