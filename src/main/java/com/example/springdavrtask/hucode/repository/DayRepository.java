package com.example.springdavrtask.hucode.repository;

import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 //bu siz ham ishlaydi
public interface DayRepository extends JpaRepository<Day,Long> {
    //native query -> sql
    //jpa query -> jpql
}
