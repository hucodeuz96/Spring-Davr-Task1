package com.example.springdavrtask.hucode.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long capasity;
}
