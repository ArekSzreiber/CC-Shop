package com.codecool.shop.product.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public void save(ProductCategory product) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteById(int id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ProductCategory findById(int id) {
        Optional<ProductCategory> result = productCategoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find product with id: " + id);
        }
    }
}
