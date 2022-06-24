package com.example.springdavrtask.hucode.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
