package com.example.order.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentDto
{
    private Long id;

    private String paymentId;

    private List<PaymentMethodDto> paymentMethod;

    //    @Enumerated(EnumType.STRING)
    private String paymentStatus;

    private Long amount;



}
