package com.codecool.shop.products;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Component
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "properties")
    private String properties;

    @Column(name = "description")
    private String description;

/*
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Category category;*/

/*  @ManyToOne
    @JoinColumn(name = "supplier_d", referencedColumnName = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;*/

}
