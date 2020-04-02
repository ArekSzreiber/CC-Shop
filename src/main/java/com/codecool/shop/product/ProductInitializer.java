package com.codecool.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Order(2)
public class ProductInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private ProductService prodSer;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Autowired
    public ProductInitializer(ProductService productService) {
        this.prodSer = productService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        prodSer.addParameters("Starfish", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameters("Staryu", "derailleur gears", "8");
        prodSer.addParameters("Starmie", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameters("Sun Staryu", "derailleur gears", new String[]{"10", "11", "12"});
        prodSer.addParameters("Sun Starmie", "derailleur gears", new String[]{"11", "12"});

        prodSer.addParameters("Steel Worm", "cells", new String[]{"110", "116"});
        prodSer.addParameters("Chrome Worm", "cells", new String[]{"110", "114"});
        prodSer.addParameters("Steel Night Crawler", "cells", new String[]{"110", "116"});
        prodSer.addParameters("Chrome Night Crawler", "cells", new String[]{"116",});

        prodSer.addParameters("Albatross", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameters("Owl", "derailleur gears", new String[]{"8"});
        prodSer.addParameters("Hawk", "derailleur gears", new String[]{"10",});
        prodSer.addParameters("Kite", "derailleur gears", new String[]{"10", "11"});
        prodSer.addParameters("Eagle", "derailleur gears", new String[]{"12"});

        prodSer.addParameters("Standard 26\"", "diameter", new String[]{"26",});
        prodSer.addParameters("Pro 26\"", "diameter", new String[]{"26",});
        prodSer.addParameters("Standard 27.5\"", "diameter", new String[]{"27.5",});
        prodSer.addParameters("Pro 27.5\"", "diameter", new String[]{"27.5",});
        prodSer.addParameters("Standard 29\"", "diameter", new String[]{"29",});
        prodSer.addParameters("Pro 29\"", "diameter", new String[]{"29",});

        prodSer.addParameters("Swift", "diameter", new String[]{"27.5",});
        prodSer.addParameters("Swift", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameters("Sparrow", "diameter", "29");
        prodSer.addParameters("Sparrow", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameters("Martin", "diameter", "26");
        prodSer.addParameters("Martin", "derailleur gears", new String[]{"8", "10", "11"});
        prodSer.addParameters("Swallow", "diameter", "29");
        prodSer.addParameters("Swallow", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameters("TRE Swift", "diameter", "27.5");
        prodSer.addParameters("TRE Swift", "derailleur gears", new String[]{"10", "11", "12"});
        prodSer.addParameters("TRE Sparrow", "diameter", "29");
        prodSer.addParameters("TRE Sparrow", "derailleur gears", new String[]{"10", "11", "12"});

        prodSer.addParameters("Dirtbuster", "diameter", "26");
        prodSer.addParameters("Dirtbuster", "surface", new String[]{"loose", "mud", "hardpack", "allround"});
        prodSer.addParameters("Dirtbuster", "color", new String[]{"black", "grey"});
        prodSer.addParameters("Maxi-Grip", "diameter", "27.5");
        prodSer.addParameters("Maxi-Grip", "surface", new String[]{"loose", "hardpack", "allround"});
        prodSer.addParameters("Maxi-Grip", "color", new String[]{"black",});
        prodSer.addParameters("Aerostunt", "diameter", "26");
        prodSer.addParameters("Aerostunt", "surface", new String[]{"road", "hardpack", "allround"});
        prodSer.addParameters("Aerostunt", "color", new String[]{"black", "orange"});
        prodSer.addParameters("Vortex", "diameter", "29");
        prodSer.addParameters("Vortex", "surface", new String[]{"indoor", "road", "hardpack"});
        prodSer.addParameters("Vortex", "color", new String[]{"black"});
        prodSer.addParameters("Velocity", "diameter", "27.5");
        prodSer.addParameters("Velocity", "surface", new String[]{"road",});
        prodSer.addParameters("Velocity", "color", new String[]{"black",});
        prodSer.addParameters("Road Fighter", "diameter", "29");
        prodSer.addParameters("Road Fighter", "surface", new String[]{"road", "indoor"});
        prodSer.addParameters("Road Fighter", "color", new String[]{"black", "white"});
        prodSer.addParameters("Mountain Chamois", "diameter", "29");
        prodSer.addParameters("Mountain Chamois", "surface", new String[]{"mud", "loose", "hardpack", "downhill", "allround"});
        prodSer.addParameters("Mountain Chamois", "color", "black");
        prodSer.addParameters("Mountain Crawler", "diameter", "27.5");
        prodSer.addParameters("Mountain Crawler", "surface", new String[]{"mud", "loose", "hardpack", "downhill", "allround"});
        prodSer.addParameters("Mountain Crawler", "color", "black");
        prodSer.addParameters("Forest Mouse", "diameter", "26");
        prodSer.addParameters("Forest Mouse", "surface", new String[]{"hardpack", "allround"});
        prodSer.addParameters("Forest Mouse", "color", "black");
        prodSer.addParameters("Sand Shrew", "diameter", "27.5");
        prodSer.addParameters("Sand Shrew", "surface", new String[]{"hardpack", "allround", "loose"});
        prodSer.addParameters("Sand Shrew", "color", "black");
        prodSer.addParameters("Sand Rat", "diameter", "29");
        prodSer.addParameters("Sand Rat", "surface", new String[]{"mud", "loose", "hardpack", "allround"});
        prodSer.addParameters("Sand Rat", "color", "black");
        logger.info("Bike parts parameters initialized");
    }
}

