package com.example.springdavrtask.hucode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
    private String salary;


    @JsonIgnore
    @OneToMany(mappedBy ="teacher")
    private List<Group> groupList;
}
