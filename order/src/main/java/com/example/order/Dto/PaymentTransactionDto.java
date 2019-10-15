package com.example.order.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTransactionDto {
    private Long id;
    private Long paymentTransactionId;
    private Long processedAmount;
    private Long requestedAmount;
}
