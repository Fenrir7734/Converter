package org.example.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {

    private static String number;
    private static String result;
    private static String from;
    private static String to;

    private static final List<String> converterHistory = new ArrayList<>();

    public static String getConversionHistory() {
        StringBuilder history = new StringBuilder();

        for (String line: converterHistory) {
            history.append(line).append("\n");
        }
        return history.toString();
    }

    public static void addConversionToHistory() {
        try {
            boolean isNumber = true;
            try {
                Integer.parseInt(from);
                Integer.parseInt(to);
            } catch (Exception e) {
                isNumber = false;
            }

            if(isNumber) {
                converterHistory.add("(" + from + ") " + number.toUpperCase() + " -> " + "(" + to + ") " + result.toUpperCase());
            } else {
                converterHistory.add(number + " " + from + " -> " + result + " " + to);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setNumber(String number, int unit) {
        ConversionHistory.number = number;
        ConversionHistory.from = String.valueOf(unit);
    }

    public static void setResult(String result, int unit) {
        ConversionHistory.result = result;
        ConversionHistory.to = String.valueOf(unit);
    }

    public static void setNumber(BigDecimal number, String unit) {
        ConversionHistory.number = number.toString();
        ConversionHistory.from = unit;
    }

    public static void setResult(BigDecimal result, String unit) {
        ConversionHistory.result = result.toString();
        ConversionHistory.to = unit;
    }
}