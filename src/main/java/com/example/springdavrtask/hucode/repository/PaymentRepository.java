package com.example.springdavrtask.hucode.repository;

import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    //native query -> sql
    //jpa query -> jpql
}
