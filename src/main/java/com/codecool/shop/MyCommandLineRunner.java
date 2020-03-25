package com.codecool.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
//@Order(1) too much Order(s) is bad practice
public class MyCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            logger.info("First MyCommandLineRunner parameter: " + args[0]);
        } else {
            logger.info("No args provided");
        }
    }
}
