package com.codecool.shop.product;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceImplTest {

    @Mock
    ProductRepository mockRepository;

    @Disabled
    @Test
    void getAllProducts() {
        ProductServiceImpl psi = new ProductServiceImpl(mockRepository);
        Product product = new Product();
        psi.save(product);
        assertEquals(1, psi.getAllProducts().size());

    }
}