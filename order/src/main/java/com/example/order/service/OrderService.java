package com.example.order.service;

import com.example.order.Dto.OrderDto;
import com.example.order.Dto.PaymentDto;
import com.example.order.domain.Order;
import com.example.order.domain.OrderLine;
import com.example.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    long total=0,order_total=0;
    @Override
    public Order save(Order order) {

        List<OrderLine> orderlines=order.getOrderLines();

        for(int i=0;i<orderlines.size();i++)
        {
            total=0;
            OrderLine orderLine=orderlines.get(i);
            long amount=(orderLine.getQuantity())*(orderLine.getUnitPrice());
            total=total+amount;
            orderLine.setSubTotal(total);
            order_total=order_total+total;

        }
        order.setOrderTotal(order_total);
//        PaymentDto paymentDto=orderDto.getPayment();
//        paymentDto.setAmount(order_total);
//        Order order=modelMapper.map(orderDto,Order.class);
        //order.setPaymentId(orderDto.getPayment().getPaymentId());
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Order> put(Long id, Order order) {
       Optional<Order> order1=orderRepository.findById(id);

       if(order1.isPresent())
       {
           orderRepository.save(order);
       }
       return null;
    }

    @Override
    public Order getOrderByOrderId(String orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

}
