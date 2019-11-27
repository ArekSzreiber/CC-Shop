package com.codecool.shop.shop.service.impl;

import com.codecool.shop.shop.entity.Product;
import com.codecool.shop.shop.repository.ProductRepository;
import com.codecool.shop.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = this.productRepository.findById(id);
        if(!product.isPresent()){
            throw new RuntimeException("item with" + id + "not found");
        }
        return product.get();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }



}
