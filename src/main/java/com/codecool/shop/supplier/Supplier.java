package com.codecool.shop.supplier;

import com.codecool.shop.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

}
