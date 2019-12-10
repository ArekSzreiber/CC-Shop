package com.codecool.shop.category;

import com.codecool.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find product with id: " + id);
        }
    }

    @Override
    public List<Product> findAllProductsByCategoryId(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get().getProducts();
        } else {
            throw new RuntimeException("Did not find category with id: " + id);
        }
    }
}
