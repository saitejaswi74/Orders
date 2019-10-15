package com.example.order.Dto;

import com.example.order.domain.CustomerDetails;
import com.example.order.domain.OrderLine;
import com.example.order.domain.SellingChannel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto
{
    private Long id;
    private String orderId;
    private Boolean isConfirmed;
    private Boolean isCancelled;
    private CustomerDetails customerDetails;

    private Boolean orderStatus;
    private SellingChannel sellingChannel;
    private PaymentDto payment;
    private List<OrderLine> orderLines;
    private Long orderTotal;


}
