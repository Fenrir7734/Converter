package org.example.units;

public enum UnitsCategory {

    LENGTH("Length"),
    AREA("Area"),
    WEIGHT("Weight"),
    VOLUME("Volume"),
    //TEMPERATURE("Temperature"),
    TIME("Time"),
    SPEED("Speed"),
    PRESSURE("Pressure"),
    FORCE("Force"),
    WORK("Work"),
    POWER("Power"),
    ANGLE("Angle"),
    DATA("Data"),
    FUEL("Fuel"),
    COOKING("Cooking"),
    TEMPERATURE("Temperature"),
    PREFIXES("Prefixes");


    private final String categoryName;

    UnitsCategory(String c) {
        this.categoryName = c;
    }

    public String get() {
        return this.categoryName;
    }
}