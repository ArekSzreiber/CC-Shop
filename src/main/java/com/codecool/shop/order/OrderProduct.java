package com.codecool.shop.order;

import com.codecool.shop.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Component
@Entity
@Table(schema = "public")
@Embeddable
public class OrderProduct implements Serializable {

    // todo https://www.baeldung.com/jpa-many-to-many#2-creating-a-composite-key-in-jpa
    @Id
    private Integer id; // todo use order_id and product_id as PK
    // https://www.baeldung.com/jpa-composite-primary-keys

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column
    private Integer amount;

}
