package com.codecool.shop.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;

    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
}
