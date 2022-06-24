package com.example.springdavrtask.hucode.dto;

import com.example.springdavrtask.hucode.response.AppErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author "Husniddin Ulachov"
 * @created 10:14 PM on 6/24/2022
 * @project Spring-Davr-Task
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseDto<T> {
    private String message;
    private boolean success;
    private T data;
    private AppErrorDTO errorDTO;
}
