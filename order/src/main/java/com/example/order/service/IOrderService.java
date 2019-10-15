package com.example.order.service;

import com.example.order.Dto.OrderDto;
import com.example.order.domain.Order;

import java.util.Optional;

public interface IOrderService {

    Order save(Order order);

    Optional<Order> getById(Long id);

    void deleteById(Long id);

    Optional<Order> put(Long id, Order order);

    Order getOrderByOrderId(String orderId);

}
