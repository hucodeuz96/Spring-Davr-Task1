package com.example.springdavrtask.hucode.repository;

import com.example.springdavrtask.hucode.entity.Course;
import com.example.springdavrtask.hucode.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    //native query -> sql
    //jpa query -> jpql
}
