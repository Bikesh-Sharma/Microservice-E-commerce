package com.ecom;

import com.ecom.dto.PaymentRequestDto;
import com.ecom.dto.PaymentResponseDto;
import com.ecom.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentResponseDto> processPayments(@RequestBody PaymentRequestDto paymentRequestDto){
        PaymentResponseDto response = paymentService.processPayment(paymentRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponseDto> getPaymentDetails(@PathVariable String orderId){
        PaymentResponseDto paymentResponseDto = paymentService.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(paymentResponseDto);
    }
}
