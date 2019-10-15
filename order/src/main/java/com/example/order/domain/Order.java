package com.example.order.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rs_order")
@DynamicUpdate
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderId;
    private Boolean isConfirmed;
    private Boolean isCancelled;

    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;


    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Boolean orderStatus;

    @ManyToOne()
    private SellingChannel sellingChannel;

    private String paymentId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<OrderLine> orderLines;

    private Long orderTotal;

    @PrePersist
    public void prePersist()
    {
        orderLines.forEach(orderLine -> orderLine.setOrder(this));
    }
    @PreUpdate
    public void preUpdate()
    {
        orderLines.forEach(orderLine -> orderLine.setOrder(this));
    }

}
