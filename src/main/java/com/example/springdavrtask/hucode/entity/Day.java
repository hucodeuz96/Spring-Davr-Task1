package com.example.springdavrtask.hucode.entity;

import lombok.*;

import javax.persistence.*;


/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "day")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
