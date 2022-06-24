package com.example.springdavrtask.hucode.repository;

import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface StatusRepository extends JpaRepository<Status,Long> {
    //native query -> sql
    //jpa query -> jpql
}
