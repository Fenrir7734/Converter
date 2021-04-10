package org.example.converter;

import org.example.units.Unit;

import java.math.BigDecimal;

public class TemperatureConverter extends Converter{

    @Override
    protected void toBase() {
        switch (this.from) {
            case "K":
                kelvinToCelsius();
                break;
            case Unit.DEGREE + "F":
                fahrenheitToCelsius();
                break;
            case Unit.DEGREE + "R":
                rankineToCelsius();
                break;
            case Unit.DEGREE + "Re":
                reaumurToCelsius();
                break;
        }
    }

    @Override
    protected void fromBase() {
        switch (this.to) {
            case "K":
                celsiusToKelvin();
                break;
            case Unit.DEGREE + "F":
                celsiusToFahrenheit();
                break;
            case Unit.DEGREE + "R":
                celsiusToRankine();
                break;
            case Unit.DEGREE + "Re":
                celsiusToReaumur();
                break;
        }
    }

    private void celsiusToKelvin() {
        this.number = this.number.add(new BigDecimal("273.15"));
    }

    private void kelvinToCelsius() {
        this.number = this.number.subtract(new BigDecimal("273.15"));
    }

    private void celsiusToFahrenheit() {
        this.number = this.number.multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
    }

    private void fahrenheitToCelsius() {
        this.number = this.number.subtract(new BigDecimal("32")).divide(new BigDecimal("1.8"), mc);
    }

    private void celsiusToRankine() {
        this.number = this.number.multiply(new BigDecimal("1.8")).add(new BigDecimal("491.67"));
    }

    private void rankineToCelsius() {
        this.number = this.number.subtract(new BigDecimal("491.67")).divide(new BigDecimal("1.8"), mc);
    }

    private void celsiusToReaumur() {
        this.number = this.number.multiply(new BigDecimal("0.8"));
    }

    private void reaumurToCelsius() {
        this.number = this.number.divide(new BigDecimal("0.8"), mc);
    }
}