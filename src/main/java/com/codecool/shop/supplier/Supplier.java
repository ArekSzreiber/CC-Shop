package com.codecool.shop.supplier;

import com.codecool.shop.product.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Component
@Entity
@Table(schema = "public")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private List<Product> products;

    public boolean hasNoProduct() {
        return products.isEmpty();
    }

    public List<Product> getProducts() {
        return products;
    }

}
