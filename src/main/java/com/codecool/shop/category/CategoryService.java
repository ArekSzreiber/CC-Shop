package com.codecool.shop.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAllCategories();

    Category save(Category category);

    Category findById(int id);

}
