package com.codecool.shop.supplier;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public interface SupplierService {

    List<Supplier> getAllSuppliers();

    Supplier findById(int id) throws EntityNotFoundException;


}
