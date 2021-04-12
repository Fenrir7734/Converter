package com.fenrir.units;

import java.math.BigDecimal;

public class Unit {

    public static final String SUPERSCRIPT_TWO ="\u00B2";
    public static final String SUPERSCRIPT_THREE = "\u00B3";
    public static final String SUBSCRIPT_TWO = "\u2082";
    public static final String MULTIPLICATION_DOT = "\u22C5";
    public static final String DEGREE = "\u00B0";

    private final String unit;
    private final BigDecimal valueRelativeToTheBaseUnit;

    public Unit(String unit, BigDecimal valueRelativeToTheBaseUnit) {
        this.unit = unit;
        this.valueRelativeToTheBaseUnit = valueRelativeToTheBaseUnit;
    }

    public Unit(String unit) {
        this(unit, null);
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getValueRelativeToTheBaseUnit() {
        return valueRelativeToTheBaseUnit;
    }
}