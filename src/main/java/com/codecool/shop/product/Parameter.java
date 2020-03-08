package com.codecool.shop.product;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "parameter",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "value"})})
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;

    @ManyToMany(mappedBy = "parameters")
    private Set<Product> products = new HashSet<>();
}
