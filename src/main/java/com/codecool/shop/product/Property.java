package com.codecool.shop.product;

import javax.persistence.Entity;

public enum Property {
    BLACK("black", Type.COLOR),
    GREEN("green", Type.COLOR),
    GREY("grey", Type.COLOR),
    NAVY("navy", Type.COLOR),
    ORANGE("orange", Type.COLOR),
    PURPLE("purple", Type.COLOR),
    WHITE("white", Type.COLOR),
    _26("26\"", Type.DIAMETER),
    _27_5("27.5\"", Type.DIAMETER),
    _29("29\"", Type.DIAMETER),
    _110("110", Type.NUMBER_OF_CELLS),
    _116("116", Type.NUMBER_OF_CELLS),
    _7("7", Type.NUMBER_OF_GEARS),
    _8("8", Type.NUMBER_OF_GEARS),
    _9("9", Type.NUMBER_OF_GEARS),
    _10("10", Type.NUMBER_OF_GEARS),
    _11("11", Type.NUMBER_OF_GEARS),
    _12("12", Type.NUMBER_OF_GEARS),
    _36("36", Type.NUMBER_OF_TEETH),
    HARDPACK("hardpack", Type.SURFACE),
    LOOSE("loose", Type.SURFACE),
    MUD("mud", Type.SURFACE),
    ROAD("road", Type.SURFACE),

    ;

    private String value;
    private Type type;

    private Property(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Property{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
