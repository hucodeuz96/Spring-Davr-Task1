package com.example.springdavrtask.hucode.controller;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.dto.PaymentDto;
import com.example.springdavrtask.hucode.entity.Payment;
import com.example.springdavrtask.hucode.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Husniddin Ulachov"
 * @created 9:36 PM on 6/17/2022
 * @project Spring-Davr-Task
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping
    public ApiResponse<Payment> save(@RequestBody PaymentDto paymentDto){
        Payment payment = paymentService.addPayment(paymentDto);
        return new ApiResponse<>("Added",true,payment);
    }
    @GetMapping("/all")
    public ApiResponse<List<Payment>> getAll(){
        return new ApiResponse<>("successfully",true,paymentService.getAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<Payment> getOne(@PathVariable Long id){
        Payment one = paymentService.getOne(id);
        return new ApiResponse<>("took",true,one);
    }
    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePayment(@PathVariable Long id){
        paymentService.deleteById(id);
       return new ApiResponse<>("Successfully",true,"deleted");
    }
    @PutMapping("/{id}")
    public ApiResponse<Payment> update(@PathVariable Long id, @RequestBody PaymentDto dto){
        return paymentService.updateById(id, dto);
    }


}
