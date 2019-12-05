package com.codecool.shop.productCategories;

import com.codecool.shop.products.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Component
@Entity
@Table(schema = "public")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Product> products;
}
