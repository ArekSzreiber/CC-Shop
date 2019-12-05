package com.codecool.shop.products;

import com.codecool.shop.productCategories.ProductCategory;
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
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    //zostawiam to jako przykład, do usunięcia z czasem
    /*
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Category category;*/

/*  @ManyToOne
    @JoinColumn(name = "supplier_d", referencedColumnName = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;*/
}
