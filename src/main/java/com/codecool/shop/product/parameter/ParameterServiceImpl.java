package com.codecool.shop.product.parameter;

import com.codecool.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterServiceImpl implements ParameterService {
    private ParameterTypeRepository typeRepository;
    private ParameterValueRepository valueRepository;

    @Autowired
    public ParameterServiceImpl(ParameterTypeRepository parameterTypeRepository,
                                ParameterValueRepository parameterValueRepository) {
        this.typeRepository = parameterTypeRepository;
        this.valueRepository = parameterValueRepository;
    }


    @Override
    public ParameterType save(ParameterType parameterType) {
        return typeRepository.save(parameterType);
    }

    @Override
    public ParameterValue save(ParameterValue parameterValue) {
        return valueRepository.save(parameterValue);
    }

    @Override
    public ParameterValue findParameterValue(String parameterTypeName, String parameterValue) {
        // retrieving all parameters from db and then finding one is strongly not optimal
        // as I didn't find out how to make  proper query  using hibernate (how to use session?)
        // and there are only few parameters, I decided to use this approach :<
        // todo refactor
        Iterable<ParameterValue> parameterValues = valueRepository.findAll();
        for (ParameterValue current : parameterValues) {
            if (current.equals(parameterTypeName, parameterValue)) {
                return current;
            }
        }
        return null;
    }


    @Override
    public ParameterValue findParameterValue(String filter) {
        String[] parameters = filter.split(":");
        String typeName = parameters[0];
        String valueName = parameters[1];
        return findParameterValue(typeName, valueName);
    }

    @Override
    public List<Product> filterByParameterValue(List<Product> products, ParameterValue parameterValue) {
        return products.stream()
                .filter(product -> product.getParameters().contains(parameterValue))
                .collect(Collectors.toList());
    }


}
