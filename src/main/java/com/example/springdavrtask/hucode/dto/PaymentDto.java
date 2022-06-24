package com.example.springdavrtask.hucode.dto;
import lombok.*;
import com.example.springdavrtask.hucode.entity.PayType;
import com.example.springdavrtask.hucode.entity.Student;

import java.util.Date;

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
public class PaymentDto {
    private Long id;
    private Double sum;
    private String description;
    private Long studentId;
    private Long payTypeId;
}
