package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.dto.GroupDto;
import com.example.springdavrtask.hucode.dto.ResGroupDto;
import com.example.springdavrtask.hucode.entity.Group;
import com.example.springdavrtask.hucode.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 5:00 PM on 6/16/2022
 * @project Spring-Davr-Task
 */
@RequestMapping("/group")
@RequiredArgsConstructor
@RestController// json qaytaradi{//@Controller  //@ResponseBody}
public class GroupController {
    private final GroupService groupService;
    @PostMapping
    public ApiResponse<Group> save(@RequestBody GroupDto groupDto){
        Group group = groupService.addGroup(groupDto);
        return new ApiResponse<>("Added",true,group);
    }
    @GetMapping("/all")
    public ApiResponse<List<ResGroupDto>> getAll(){
        return new ApiResponse<>("successfully",true,groupService.getAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<Group> getOne(@PathVariable Long id){
        Group one = groupService.getOne(id);
        return new ApiResponse<>("took",true,one);
    }
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteGroup(@PathVariable Long id){
        groupService.deleteById(id);
        return new ApiResponse<>("Successfully",true,"deleted");
    }
    @PutMapping("/{id}")
    public ApiResponse<Group> update(@PathVariable Long id, @RequestBody GroupDto dto){
        return groupService.updateById(id, dto);
    }

}
