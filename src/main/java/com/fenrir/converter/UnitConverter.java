package com.fenrir.converter;


import com.fenrir.units.Unit;

public class UnitConverter extends Converter{

    @Override
    protected void toBase() {
        Unit unit = searchUnit(this.from);

        assert unit != null;
        this.number = this.number.divide(unit.getValueRelativeToTheBaseUnit(), mc);
    }

    @Override
    protected void fromBase() {
        Unit unit = searchUnit(this.to);

        assert unit != null;
        this.number = this.number.multiply(unit.getValueRelativeToTheBaseUnit());
    }

    private Unit searchUnit(String s) {
        for(Unit unit: units) {
            if(unit.getUnit().equals(s)) {
                return unit;
            }
        }
        return null;
    }

}