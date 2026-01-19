package com.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    private String paymentId;
    private String orderId;
    private String customerId;
    private Double amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
    private String transactionId;

}
