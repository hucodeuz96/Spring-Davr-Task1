package com.example.springdavrtask.hucode.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "payType")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
