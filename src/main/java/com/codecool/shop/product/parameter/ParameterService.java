package com.codecool.shop.product.parameter;

import org.springframework.stereotype.Service;

@Service
public interface ParameterService {
    ParameterType save(ParameterType parameterType);

    ParameterValue save(ParameterValue parameterValue);


    ParameterValue findParameterValue(String parameterTypeName, String parameterValue);

    boolean parametersNotEmpty();
}
