package com.example.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class SellingChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long sellingChannelId;
    private String sellingChannelName;

    @OneToMany(mappedBy = "sellingChannel")
    @JsonIgnore
    private List<Order> order;

}
