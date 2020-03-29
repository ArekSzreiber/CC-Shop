package com.codecool.shop.product.parameter;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ParameterInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private ParameterService ps;

    @Autowired
    public ParameterInitializer(ParameterService parameterService) {
        this.ps = parameterService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ParameterType type;
        try {
            type = ps.save(new ParameterType("color"));
            ps.save(new ParameterValue(type, "grey"));
            ps.save(new ParameterValue(type, "green"));
            ps.save(new ParameterValue(type, "navy"));
            ps.save(new ParameterValue(type, "black"));
            ps.save(new ParameterValue(type, "orange"));
            ps.save(new ParameterValue(type, "purple"));
            ps.save(new ParameterValue(type, "white"));

            type = ps.save(new ParameterType("diameter"));
            ps.save(new ParameterValue(type, "26"));
            ps.save(new ParameterValue(type, "27.5"));
            ps.save(new ParameterValue(type, "29"));

            type = ps.save(new ParameterType("cells"));
            ps.save(new ParameterValue(type, "110"));
            ps.save(new ParameterValue(type, "114"));
            ps.save(new ParameterValue(type, "116"));
            ps.save(new ParameterValue(type, "126"));
            ps.save(new ParameterValue(type, "138"));

            type = ps.save(new ParameterType("derailleur gears"));
            ps.save(new ParameterValue(type, "6"));
            ps.save(new ParameterValue(type, "7"));
            ps.save(new ParameterValue(type, "8"));
            ps.save(new ParameterValue(type, "9"));
            ps.save(new ParameterValue(type, "10"));
            ps.save(new ParameterValue(type, "11"));
            ps.save(new ParameterValue(type, "12"));

            type = ps.save(new ParameterType("teeth"));
            ps.save(new ParameterValue(type, "32"));
            ps.save(new ParameterValue(type, "36"));
            ps.save(new ParameterValue(type, "40"));
            ps.save(new ParameterValue(type, "42"));
            ps.save(new ParameterValue(type, "44"));

            type = ps.save(new ParameterType("surface"));
            ps.save(new ParameterValue(type, "allround"));
            ps.save(new ParameterValue(type, "downhill"));
            ps.save(new ParameterValue(type, "hardpack"));
            ps.save(new ParameterValue(type, "indoor"));
            ps.save(new ParameterValue(type, "loose"));
            ps.save(new ParameterValue(type, "mud"));
            ps.save(new ParameterValue(type, "road"));
            ps.save(new ParameterValue(type, "sand"));
            ps.save(new ParameterValue(type, "snow"));
        } catch (ConstraintViolationException | DataIntegrityViolationException ignored) {
        }
    }
}
