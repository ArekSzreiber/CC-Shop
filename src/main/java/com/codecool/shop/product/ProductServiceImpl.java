package com.codecool.shop.product;

import com.codecool.shop.product.parameter.ParameterService;
import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ParameterService parameterService;
//    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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
        Product p = productRepository.findByTitle(title);
        if (p == null) {
            try {
                throw new Exception("Could not find Product with title: " + title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void addParameter(String productTitle, String parameterTypeName, String parameterName) {
        Product product = productRepository.findByTitle(productTitle);
        ParameterValue parameterValue = parameterService.findParameterValue(parameterTypeName, parameterName);
        product.addParameter(parameterValue);
        productRepository.save(product);
    }

    @Override
    public void addParameter(String productTitle, String parameterTypeName, String[] parameterValues) {
        for (String parameterValue : parameterValues) {
            addParameter(productTitle, parameterTypeName, parameterValue);
        }
    }


    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }


}
