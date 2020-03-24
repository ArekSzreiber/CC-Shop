package com.codecool.shop.category;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyTypeId;

   @Column(unique = true)
   private String name;

}
