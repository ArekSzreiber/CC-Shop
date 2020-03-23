package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Component
@Entity
@Table(schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "category_id", "supplier_id"}))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column
    @NotEmpty
    private String title;

    @Column
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageURL;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    private Supplier supplier;

}
