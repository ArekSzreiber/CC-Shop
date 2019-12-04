package com.codecool.shop.product.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {

    List<ProductCategory> getAllCategories();

    void save(ProductCategory product);

    void deleteById(int id);

    ProductCategory findById(int id);


}
