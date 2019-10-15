package com.example.order.controller;
import com.example.order.Dto.OrderDto;
import com.example.order.Dto.PaymentDto;
import com.example.order.assembler.Assembler;
import com.example.order.clientservice.ApiClient;
import com.example.order.domain.Order;
import com.example.order.domain.PaymentStatus;
import com.example.order.service.IOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {
    @Autowired
    IOrderService iOrderService;

    @Autowired
    Assembler assembler;

    @Autowired
    ApiClient apiClient;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/save")
    OrderDto save(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        PaymentDto paymentDto=orderDto.getPayment();
        PaymentDto paymentDto1= apiClient.save(paymentDto);
//                orderdto to order entity
        Order order=assembler.convertToEntity(orderDto);

//        get payement id and status from payment
        order.setPaymentId(paymentDto1.getPaymentId());
        order.setPaymentStatus(PaymentStatus.valueOf(paymentDto1.getPaymentStatus()));
//        set in ur order entity
        Order order1=iOrderService.save(order);
        String paymentId=order1.getPaymentId();
//        convert entity to dto
        OrderDto orderDto1=assembler.convertToOrderDto(order1);

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderDto1));

        PaymentDto paymentDto2= apiClient.getPayment(paymentId);
//        get call to payment
//        add add the payment detail into ur orderdto
        orderDto1.setPayment(paymentDto2);
//        return orderdto
        return orderDto1;
    }


    @GetMapping("/get/{id}")
    OrderDto getById(@PathVariable("id") Long id) {
        Order order= iOrderService.getById(id).get();
        String paymentId=order.getPaymentId();
        PaymentDto paymentDto=apiClient.getPayment(paymentId);
        OrderDto orderDto=assembler.convertToOrderDto(order);
        orderDto.setPayment(paymentDto);
        return orderDto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id)
    {
        iOrderService.deleteById(id);
    }

    @PutMapping("/put/{id}")
    Optional<Order> put(@PathVariable Long id,@RequestBody Order order)
    {
        return iOrderService.put(id,order);
    }

    @GetMapping("/getById/{id}")
    Order findOrderByOrderId(@PathVariable("id") String orderId)
    {
        return iOrderService.getOrderByOrderId(orderId);
    }

}