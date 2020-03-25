package com.codecool.shop.category;

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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override // list of products omitted to avoid cycle
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
