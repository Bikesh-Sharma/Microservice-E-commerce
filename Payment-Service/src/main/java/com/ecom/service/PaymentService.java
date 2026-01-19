package com.ecom.service;

import com.ecom.dto.PaymentRequestDto;
import com.ecom.dto.PaymentResponseDto;
import com.ecom.dto.PaymentStatus;
import com.ecom.entity.Payment;
import com.ecom.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderClient orderClient;

    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto){
        String paymentId = generatePaymentId();
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setOrderId(paymentRequestDto.getOrderId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setCustomerId(paymentRequestDto.getCustomerId());
        payment.setPaymentDate(LocalDateTime.now());
        boolean paymentSuccess = new Random().nextBoolean();
        if (paymentSuccess){
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
            payment.setTransactionId(UUID.randomUUID().toString());
            orderClient.updateOrderStatus(paymentRequestDto.getOrderId(),"CONFIRMED");
        }else {
            payment.setPaymentStatus(PaymentStatus.FAILED);
            payment.setTransactionId("N/A");
            orderClient.updateOrderStatus(paymentRequestDto.getOrderId(),"CANCELLED");
        }
        paymentRepository.save(payment);
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setPaymentId(paymentId);
        paymentResponseDto.setOrderId(payment.getOrderId());
        paymentResponseDto.setAmount(payment.getAmount());
        paymentResponseDto.setCustomerId(payment.getCustomerId());
        paymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
        paymentResponseDto.setPaymentDate(LocalDateTime.now());
        paymentResponseDto.setTransactionId(payment.getTransactionId());
        return paymentResponseDto;
    }

    //get paymentDetailByOrderId
    public PaymentResponseDto getPaymentByOrderId(String orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        if (payment==null){
            return null; // or throw an exception
        }
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setPaymentId(payment.getPaymentId());
        paymentResponseDto.setOrderId(payment.getOrderId());
        paymentResponseDto.setAmount(payment.getAmount());
        paymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
        paymentResponseDto.setTransactionId(payment.getTransactionId());
        return paymentResponseDto;
    }

    private String generatePaymentId(){
        return "pay-" + UUID.randomUUID().toString().substring(0,8);
    }


}
