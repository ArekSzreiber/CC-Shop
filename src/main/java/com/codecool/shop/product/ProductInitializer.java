package com.codecool.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ProductInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private ProductService prodSer;

    @Autowired
    public ProductInitializer(ProductService productService) {
        this.prodSer = productService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        prodSer.addParameter("Starfish", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameter("Staryu", "derailleur gears", "8");
        prodSer.addParameter("Starmie", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameter("Sun Staryu", "derailleur gears", new String[]{"10", "11", "12"});
        prodSer.addParameter("Sun Starmie", "derailleur gears", new String[]{"11", "12"});

        prodSer.addParameter("Steel Worm", "cells", new String[]{"110", "116"});
        prodSer.addParameter("Chrome Worm", "cells", new String[]{"110", "114"});
        prodSer.addParameter("Steel Night Crawler", "cells", new String[]{"110", "116"});
        prodSer.addParameter("Chrome Night Crawler", "cells", new String[]{"116",});

        prodSer.addParameter("Albatross", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameter("Owl", "derailleur gears", new String[]{"8"});
        prodSer.addParameter("Hawk", "derailleur gears", new String[]{"10",});
        prodSer.addParameter("Kite", "derailleur gears", new String[]{"10", "11"});
        prodSer.addParameter("Eagle", "derailleur gears", new String[]{"12"});

        prodSer.addParameter("Standard 26\"", "diameter", new String[]{"26",});
        prodSer.addParameter("Pro 26\"", "diameter", new String[]{"26",});
        prodSer.addParameter("Standard 27.5\"", "diameter", new String[]{"27.5",});
        prodSer.addParameter("Pro 27.5\"", "diameter", new String[]{"27.5",});
        prodSer.addParameter("Standard 29\"", "diameter", new String[]{"29",});
        prodSer.addParameter("Pro 29\"", "diameter", new String[]{"29",});

        prodSer.addParameter("Swift", "diameter", new String[]{"26",});
        prodSer.addParameter("Swift", "derailleur gears", new String[]{"7", "8"});
        prodSer.addParameter("Sparrow", "diameter", new String[]{"26", "27.5"});
        prodSer.addParameter("Sparrow", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameter("Martin", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("Martin", "derailleur gears", new String[]{"8", "10", "11"});
        prodSer.addParameter("Swallow", "diameter", new String[]{"26", "27.5", "29"});
        prodSer.addParameter("Swallow", "derailleur gears", new String[]{"8", "10"});
        prodSer.addParameter("TRE Swift", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("TRE Swift", "derailleur gears", new String[]{"10", "11", "12"});
        prodSer.addParameter("TRE Sparrow", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("TRE Sparrow", "derailleur gears", new String[]{"10", "11", "12"});

        prodSer.addParameter("Dirtbuster", "diameter", new String[]{"26", "27.5"});
        prodSer.addParameter("Dirtbuster", "surface", new String[]{"loose", "mud", "hardpack", "allround"});
        prodSer.addParameter("Dirtbuster", "color", new String[]{"black", "grey"});
        prodSer.addParameter("Maxi-Grip", "diameter", new String[]{"26", "27.5"});
        prodSer.addParameter("Maxi-Grip", "surface", new String[]{"loose", "hardpack", "allround"});
        prodSer.addParameter("Maxi-Grip", "color", new String[]{"black",});
        prodSer.addParameter("Aerostunt", "diameter", new String[]{"26", "27.5"});
        prodSer.addParameter("Aerostunt", "surface", new String[]{"road", "hardpack", "allround"});
        prodSer.addParameter("Aerostunt", "color", new String[]{"black",});
        prodSer.addParameter("Vortex", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("Vortex", "surface", new String[]{"indoor", "road", "hardpack"});
        prodSer.addParameter("Vortex", "color", new String[]{"black"});
        prodSer.addParameter("Velocity", "diameter", new String[]{"26", "27.5", "29"});
        prodSer.addParameter("Velocity", "surface", new String[]{"road",});
        prodSer.addParameter("Velocity", "color", new String[]{"black",});
        prodSer.addParameter("Road Fighter", "diameter", "29");
        prodSer.addParameter("Road Fighter", "surface", new String[]{"road", "indoor"});
        prodSer.addParameter("Road Fighter", "color", new String[]{"black", "white"});
        prodSer.addParameter("Mountain Chamois", "diameter", "29");
        prodSer.addParameter("Mountain Chamois", "surface", new String[]{"mud", "loose", "hardpack", "downhill", "allround"});
        prodSer.addParameter("Mountain Chamois", "color", "black");
        prodSer.addParameter("Mountain Crawler", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("Mountain Crawler", "surface", new String[]{"mud", "loose", "hardpack", "downhill", "allround"});
        prodSer.addParameter("Mountain Crawler", "color", "black");
        prodSer.addParameter("Forest Mouse", "diameter", new String[]{"26",});
        prodSer.addParameter("Forest Mouse", "surface", new String[]{"hardpack", "allround"});
        prodSer.addParameter("Forest Mouse", "color", "black");
        prodSer.addParameter("Sand Shrew", "diameter", new String[]{"26", "27.5"});
        prodSer.addParameter("Sand Shrew", "surface", new String[]{"hardpack", "allround", "loose"});
        prodSer.addParameter("Sand Shrew", "color", "black");
        prodSer.addParameter("Sand Rat", "diameter", new String[]{"27.5", "29"});
        prodSer.addParameter("Sand Rat", "surface", new String[]{"mud", "loose", "hardpack", "allround"});
        prodSer.addParameter("Sand Rat", "color", "black");
    }
}

