package com.codecool.shop.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CategoryService {

    List<Category> getAllCategories();

    void save(Category category);

    void deleteById(int id);

    Category findById(int id);

}
