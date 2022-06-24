package com.example.springdavrtask.hucode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Room room;

    private Date startDate;
    private Date endDate;

    @OneToOne
    private Status status;

    @JsonIgnore
    @OneToMany
    private List<Student> student;






}
