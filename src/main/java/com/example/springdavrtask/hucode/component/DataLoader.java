package com.example.springdavrtask.hucode.component;

import com.example.springdavrtask.hucode.entity.Room;
import com.example.springdavrtask.hucode.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author "Husniddin Ulachov"
 * @created 3:09 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@Component
@RequiredArgsConstructor

public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;

    @Value("${spring.sql.init.mode}")
    String mode;
    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")) {
            roomRepository.save(new Room(1L, "314", 20L));
            roomRepository.save(new Room(2L, "315", 24L));
            roomRepository.save(new Room(3L, "316", 24L));
            roomRepository.save(new Room(4L, "317", 28L));
        }

    }
}
