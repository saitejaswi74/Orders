package com.example.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerFirstName;
    private String CustomerLastName;
    private Long customerPhone;
    private String customerEmail;

    @OneToMany(mappedBy = "customerDetails")
    @JsonIgnore
    private List<Order> order;

}