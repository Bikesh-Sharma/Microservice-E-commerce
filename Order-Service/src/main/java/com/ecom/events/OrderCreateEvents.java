package com.ecom.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateEvents {

    private String orderId;
    private String customerId;
    private String totalAmount;
}
