package com.codecool.shop.product.parameter;

import com.codecool.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParameterService {
    ParameterType save(ParameterType parameterType);

    ParameterValue save(ParameterValue parameterValue);


    ParameterValue findParameterValue(String parameterTypeName, String parameterValue);

    ParameterValue findParameterValue(String filter);

    List<Product> filterByParameterValue(List<Product> products, ParameterValue parameterValue);
}
