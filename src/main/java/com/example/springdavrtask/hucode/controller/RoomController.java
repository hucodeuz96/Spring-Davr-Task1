package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.entity.Room;
import com.example.springdavrtask.hucode.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/room")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class RoomController {

    private final RoomRepository roomRepository;

    @PostMapping
    public ApiResponse<Room> saveRoom(@RequestBody Room room) {
        Room save = roomRepository.save(room);
        return new ApiResponse<>("Saved Succesfully", true, save);
    }

    @GetMapping("/all")
    public ApiResponse<List<Room>> getAll() {
        List<Room> roomList = roomRepository.findAll();
        return new ApiResponse<>("chotki", true, roomList);
    }

    @GetMapping("/{id}")
    public ApiResponse<Room> getOne(@PathVariable long id) {
        Optional<Room> repositoryById = roomRepository.findById(id);
        if (repositoryById.isPresent()) {
            Room room = repositoryById.get();
            return new ApiResponse<>("chotki", true, room);
        } else {
            return new ApiResponse<>("chotki", true, null);
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<Room> update(@PathVariable long id, @RequestBody Room room) {
        Room roomOld = roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("room not found"));
        roomOld.setName(room.getName());
        roomOld.setCapasity(room.getCapasity());
        Room save = roomRepository.save(roomOld);
        return new ApiResponse<>("chotki", true, save);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable long id) {
        roomRepository.deleteById(id);
        return new ApiResponse<>("chotki", true, "Vapshi chotki");
    }
}
