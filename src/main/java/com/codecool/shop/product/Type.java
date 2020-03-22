package com.codecool.shop.product;

public enum Type {
    COLOR("color"),
    DIAMETER("diameter"),
    NUMBER_OF_CELLS("number_of_cells"),
    NUMBER_OF_GEARS("number_of_gears"),
    NUMBER_OF_TEETH("number_of_teeth"),
    SURFACE("surface"),
    ;

    private String name;

    Type(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                '}';
    }
}
