package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

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

    @ManyToMany
    Set<PropertyValue> properties;

//    @ElementCollection(targetClass = Property.class)
//    @CollectionTable(name = "product_property", joinColumns = @JoinColumn(name = "product_id"))
//    @Column(name = "property_id")
//    Set<Property> properties = EnumSet.noneOf(Property.class);


//    public void addProperties(Set<Property> newProperties) {
//        this.properties.addAll(newProperties);
//    }
    // there must a good way to populate products with properties

}
