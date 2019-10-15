package com.example.order.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingAddressDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String email;

}
