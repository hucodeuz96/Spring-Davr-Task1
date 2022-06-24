package com.example.springdavrtask.hucode.service;

import com.example.springdavrtask.hucode.dto.ApiResponse;
import com.example.springdavrtask.hucode.dto.PaymentDto;
import com.example.springdavrtask.hucode.entity.PayType;
import com.example.springdavrtask.hucode.entity.Payment;
import com.example.springdavrtask.hucode.entity.Student;
import com.example.springdavrtask.hucode.repository.PayTypeRepository;
import com.example.springdavrtask.hucode.repository.PaymentRepository;
import com.example.springdavrtask.hucode.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author "Husniddin Ulachov"
 * @created 9:28 PM on 6/17/2022
 * @project Spring-Davr-Task
 */
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;
    private final PayTypeRepository payTypeRepository;
    public Payment addPayment(PaymentDto paymentDto){
        Student student = studentRepository.findById(paymentDto.getStudentId()).orElseThrow(
                () -> new RuntimeException("Student not found"));
        PayType payType = payTypeRepository.findById(paymentDto.getPayTypeId()).orElseThrow(
                () -> new RuntimeException("PayType not found"));
        Payment payment = new Payment();
        payment.setDescription(paymentDto.getDescription());
        payment.setPayType(payType);
        payment.setStudent(student);
        payment.setSum(paymentDto.getSum());
        Payment save = paymentRepository.save(payment);
        return save;
    }
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
    public Payment getOne(Long id){
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("payment not found"));
    }

    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
    public ApiResponse<Payment> updateById(Long id, PaymentDto dto) {
        final Payment[] payment = {new Payment()};
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(
                () -> new RuntimeException("Student not found"));
        PayType payType = payTypeRepository.findById(dto.getPayTypeId()).orElseThrow(
                () -> new RuntimeException("PayType not found"));
        paymentRepository.findById(id).ifPresentOrElse(
                payment1 ->{
                    payment1.setStudent(student);
                    payment1.setSum(dto.getSum());
                    payment1.setPayType(payType);
                    payment1.setDescription(dto.getDescription());
                    payment[0] =payment1;
                },
                () -> new ApiResponse<>("Error",false,null));
        Payment save = paymentRepository.save(payment[0]);

        return new ApiResponse<>("Successfully",true,save);
    }
}
