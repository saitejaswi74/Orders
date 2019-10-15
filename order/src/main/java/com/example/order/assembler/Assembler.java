package com.example.order.assembler;

import com.example.order.domain.Order;
import com.example.order.Dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Assembler {

    @Autowired
    ModelMapper modelMapper;

    public OrderDto convertToOrderDto(Order order)
    {
        OrderDto orderDto=modelMapper.map(order,OrderDto.class);
       // orderDto.setPaymentId(orderDto.getPayment().getPaymentId());
        return orderDto;
    }

    public Order convertToEntity(OrderDto orderDto)
    {
        Order order=modelMapper.map(orderDto,Order.class);
        order.setPaymentId(orderDto.getPayment().getPaymentId());
        return order;
    }
}
