package com.example.springdavrtask.hucode.dto;

/**
 * @author "Husniddin Ulachov"
 * @created 10:57 AM on 6/20/2022
 * @project Spring-Davr-Task
 */
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResGroupDto {
    private String groupName;
    private String courseName;
    private String teacherName;
    private String roomName;
    private String statusName;
    private String startDate;
    private String endDate;
}
