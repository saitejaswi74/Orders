package com.example.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderLineId;

    private Boolean isCancelled;
    private String itemId;
    private Integer unitPrice;
    private Integer quantity;
    private String deliveryMethodId;

    @OneToOne(cascade = CascadeType.ALL)
    private ShippingToAddress shippingToAddress;

    @ManyToOne()
    @JsonIgnore
    private Order order;

    private Long subTotal;

}
