package com.example.springdavrtask.hucode.dto;

import com.example.springdavrtask.hucode.entity.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 7:38 PM on 6/17/2022
 * @project Spring-Davr-Task
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GroupDto {
    private Long id;
    private String name;
    private Long courseId;
    private Long teacherId;
    private Long roomId;
    private String startDate;
    private String endDate;
    private Long statusId;

}
