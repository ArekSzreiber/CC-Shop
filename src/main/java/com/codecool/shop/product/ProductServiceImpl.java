package com.codecool.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product product;
        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("Did not find product id " + id);
        }
        return product;
    }
}
