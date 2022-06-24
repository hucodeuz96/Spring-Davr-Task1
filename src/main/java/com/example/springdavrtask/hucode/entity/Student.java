
package com.example.springdavrtask.hucode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;


    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Payment> paymentList;


}
