package com.fenrir.converter;

import com.fenrir.units.Unit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public abstract class Converter {

    private String baseUnit;
    protected ArrayList<Unit> units;
    protected BigDecimal number;
    protected String from;
    protected String to;

    protected final MathContext mc = new MathContext(20, RoundingMode.HALF_UP);

    public void convert() {
        ConversionHistory.setNumber(this.number, this.from);

        if(this.from.equals(baseUnit)) {
            fromBase();
        } else if(this.to.equals(baseUnit)) {
            toBase();
        } else {
            toBase();
            fromBase();
        }

        ConversionHistory.setResult(this.number, this.to);
        ConversionHistory.addConversionToHistory();
    }

    protected abstract void toBase();

    protected abstract void fromBase();

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public String getResult() {
        this.number = this.number.round(MathContext.DECIMAL32);
        return this.number.toString();
    }

}