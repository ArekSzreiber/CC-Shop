package com.codecool.shop.order;

import com.codecool.shop.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(schema = "public")
public class OrderProduct {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id; // todo use order_id and product_id as PK

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column
    private Integer amount;

}
