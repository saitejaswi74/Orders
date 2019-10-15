package com.example.order.clientservice;

import com.example.order.Dto.OrderDto;
import com.example.order.Dto.PaymentDto;
import com.example.order.domain.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ApiClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public PaymentDto getPayment(String paymentId)
    {
        PaymentDto obj=restTemplate.getForEntity("http://192.168.1.214:8084/payment/api/v1/getById/"+paymentId,PaymentDto.class).getBody();
        return obj;

        //restTemplate.get
    }
    public PaymentDto save(PaymentDto paymentDto) throws JsonProcessingException {
//        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(paymentDto));
        PaymentDto obj=restTemplate.postForEntity("http://192.168.1.214:8084/payment/api/v1/save",paymentDto,PaymentDto.class).getBody();
        //orderDtoList.add(orderDto);
        return obj;
    }
}
