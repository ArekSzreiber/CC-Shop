package com.codecool.shop.product;

import com.codecool.shop.category.PropertyType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"property_type_id", "value"})
)
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyValueId;

    @Column
    private String value;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType type;
}
