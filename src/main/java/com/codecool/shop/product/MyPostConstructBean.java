package com.codecool.shop.product;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
@DependsOn("product")
public class MyPostConstructBean {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @PostConstruct
    void postConstruct(){
        logger.info("@PostConstruct");
    }
}
