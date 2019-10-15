package com.example.order;

import com.example.order.Dto.OrderDto;
import com.example.order.domain.Order;
import com.example.order.domain.SellingChannel;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper=new ModelMapper();
//        mapper.typeMap(Order.class,OrderDto.class).addMappings();
//        mapper.typeMap(SellingChannel.class,OrderDto.class);
        return new ModelMapper();
    }
    @Bean
    public RestTemplate getTemp(){
        return new RestTemplate();
    }

}
