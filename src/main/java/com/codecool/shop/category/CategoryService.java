package com.codecool.shop.category;

import com.codecool.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CategoryService {

    List<Category> getAllCategories();

    void save(Category product);

    void deleteById(int id);

    Category findById(int id);

    List<Product> findAllProductsByCategoryId(int id);
}
