package com.example.springdavrtask.hucode.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


/**
 * @author "Husniddin Ulachov"
 */
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double sum;

    private String description;

    @ManyToOne
    private Student student;

    @Temporal(value = TemporalType.DATE)
    @CreationTimestamp
    private Date createDate;

    @ManyToOne
    private  PayType payType;
}
