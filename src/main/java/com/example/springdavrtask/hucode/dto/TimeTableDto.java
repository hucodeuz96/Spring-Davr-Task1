package com.example.springdavrtask.hucode.dto;

import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 11:48 AM on 6/20/2022
 * @project Spring-Davr-Task
 */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TimeTableDto {
    private Long dayId;
    private String startTime;
    private String endTime;
    private List<Long> groupIds;
}
