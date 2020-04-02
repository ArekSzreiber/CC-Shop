package com.codecool.shop.product;

import com.codecool.shop.product.parameter.ParameterService;
import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ParameterService parameterService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository,
                                     ParameterService parameterService) {
        this.productRepository = productRepository;
        this.parameterService = parameterService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product getByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        if (product == null) {
            throw new EntityNotFoundException("Could not find Product with title: " + title);

        }
        return product;
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void addParameters(String productTitle, String parameterTypeName, String parameterName) {
        addParameters(productTitle, parameterTypeName, new String[]{parameterName});
    }

    @Override
    public void addParameters(String productTitle, String parameterTypeName, String[] parameterNames) {
        Product product = productRepository.findByTitle(productTitle);
        for (String parameterName : parameterNames) {
            ParameterValue parameterValue = parameterService.findParameterValue(parameterTypeName, parameterName);
            product.addParameter(parameterValue);
        }
        productRepository.save(product);
    }


    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProducts(ParameterValue parameterValue) {
        //todo just retrieve proper  Products from DB
        return parameterService.filterByParameterValue(productRepository.findAll(), parameterValue);


    }


}
