package com.example.order.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountDisplayName;
    private String accountnumber;
    private Long amount;
    private String cardExpiryMonth;
    private String cardExpiryYear;
    private String cardTypeId;
    private String currencyCode;
    private Long currentAuthAmount;
    private Long currentSettledAmount;
    private String nameOnCard;
//    @OneToOne(cascade = CascadeType.ALL)
//    // @JsonIgnore
    private BillingAddressDto billingAddress;
//    @OneToOne(cascade = CascadeType.ALL)
    private PaymentTransactionDto paymentTransaction;



}