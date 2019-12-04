package com.codecool.shop.products;

import com.codecool.shop.product.category.ProductCategory;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Component
@Entity
@Table(schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String title;

    @Column
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageURL;

    @Column
    private String properties;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductCategory productCategory;
}
