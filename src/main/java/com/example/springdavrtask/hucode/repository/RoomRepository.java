package com.example.springdavrtask.hucode.repository;

import com.example.springdavrtask.hucode.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //bu siz ham ishlaydi
public interface RoomRepository extends JpaRepository<Room,Long> {
    //native query -> sql
    //jpa query -> jpql
}
