package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Set;

@Data
@Component
@Entity
@Table(schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "category_id", "supplier_id"}))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

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

//    @Enumerated(EnumType.ORDINAL)
//    Property property; // for now just one property, later it should be a set
//
//    @ElementCollection(targetClass = Property.class)
//    @CollectionTable(name = "product_property", joinColumns = @JoinColumn(name = "product_id"))
//    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "properties")
//    private Set<Property> properties = new HashSet<>();

    // todo 1. przechowaj w bazie danych enuma
    // tabela złączeniowa

    @ElementCollection(targetClass = Property.class)
    @CollectionTable(name = "product_property", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "property_id")
    Set<Property> properties = EnumSet.noneOf(Property.class);

/*
@ElementCollection(targetClass = Platform.class)
@CollectionTable(name = "TBL_APP_PLATFORM",
    joinColumns = @JoinColumn(name = "APP_ID"))
@Column(name = "PLATFORM_ID")
*/


}
