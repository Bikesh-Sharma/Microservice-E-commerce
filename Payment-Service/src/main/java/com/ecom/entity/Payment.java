package com.ecom.entity;

import com.ecom.dto.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String paymentId;
    private String orderId;
    private String customerId;
    private Double amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;
    private String transactionId;
}
