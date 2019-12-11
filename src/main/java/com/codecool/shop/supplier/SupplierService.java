package com.codecool.shop.supplier;

import com.codecool.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    List<Supplier> getAllSuppliers();

    void save(Supplier supplier);

    void deleteById(int id);

    Supplier findById(int id);

    List<Product> findAllProductsBySupplierId(int id);

}
