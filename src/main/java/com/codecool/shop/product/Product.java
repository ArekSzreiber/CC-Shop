package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.supplier.Supplier;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

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
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    //zostawiam to jako przykład, do usunięcia z czasem
    /*
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Category category;*/

/*  @ManyToOne
    @JoinColumn(name = "supplier_d", referencedColumnName = "supplier_id", insertable = false, updatable = false)
    private Supplier supplier;*/

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", properties='" + properties + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                title.equals(product.title) &&
                Objects.equals(price, product.price) &&
                Objects.equals(imageURL, product.imageURL) &&
                Objects.equals(properties, product.properties) &&
                Objects.equals(description, product.description) &&
                category.equals(product.category) &&
                supplier.equals(product.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, imageURL, properties, description);
    }
}
