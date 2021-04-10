package org.example.converter;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberSystemConverter extends Converter{

    private int from;
    private int to;
    private String number;
    private boolean isNegative;

    public NumberSystemConverter() {
        super();
        this.from = 0;
        this.to = 0;
        this.isNegative = false;
    }

    @Override
    public void convert() {
        ConversionHistory.setNumber(this.number, this.from);

        if(from == to) {    //if starting system is equal to target system do not nothing. Final number will be the same.
            return;
        }

        if(to == 10) {
            toBase();
        } else if(from == 10) {
            fromBase();
        } else {        //if starting and target systems are different than 10, first convert number to dec system, than to target system.
            toBase();
            fromBase();
        }

        if(isNegative) {
            number = new StringBuilder(number).insert(0, "-").toString(); //if number is negative, add '-' to the beginning.
        }

        ConversionHistory.setResult(this.number, this.to);
        ConversionHistory.addConversionToHistory();
    }

    @Override
    protected void toBase() {

        if(number.contains(".")) {
            String[] arr = number.split("\\.");
            number = arr[0];
            String numberFractionPart = arr[1];
        }

        BigInteger targetNumber = new BigInteger("0");
        BigInteger system = new BigInteger(String.valueOf(from));

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(number.length() - i - 1);    //takes the next digits of the number to convert
            BigInteger digit;

            if((int) c >= 97) { //check if digit is greater or equal to 'a'. 97 because it's the corresponding number to 'a' in ASCII. Condition only true if starting system is greater than 10.
                int d = (char) ((int) c - 97 + 10);     //if the digit is b (98 in ASCII) than 98 - 97 + 10 = 11
                digit = new BigInteger(String.valueOf(d));
            } else {
                digit = new BigInteger(String.valueOf(c));
            }

            targetNumber = targetNumber.add(system.pow(i).multiply(digit));
        }

        number = targetNumber.toString().toUpperCase();

    }

    @Override
    protected void fromBase() {
        BigInteger dec = new BigInteger(number);
        BigInteger system = new BigInteger(String.valueOf(to));
        StringBuilder targetNumber = new StringBuilder();

        while(!dec.equals(BigInteger.ZERO)) {
            BigInteger digit = dec.remainder(system);   //take remainder of number divided by system
            dec = dec.divide(system);  //and actually divide this number

            if(digit.compareTo(new BigInteger("9")) > 0) {  //if digit is greater than 9, number must be convert to letter.
                int d = digit.intValue();
                targetNumber.insert(0, (char) (97 + (d - 10))); //for digit equal 11 this would be: 97 + 11 - 10 = 98. Then convert this number to char (in ASCII 98 is equal to 'b') and insert to first position in converted number.
            } else {
                targetNumber.insert(0, digit);
            }
        }

        number = targetNumber.toString().toUpperCase();

    }

    public boolean checkEnteredNumber() {  //checks if the entered number is in the specified system

        if(number.length() == 0) {
            return false;
        }

        String maxDigit = String.valueOf(from - 1); //last possible digit in specified system

        if(from > 10) {
            maxDigit = Character.toString((char) (97 + (from - 10) - 1));  //if last possible digit in system is grater than 10, convert this digit to letter e.g. for 11 it will be B.
        }                                                                            //I am using ASCII

        String regex = "([1-" + maxDigit + "]" + "[0-" + maxDigit + "]*[.])?[0-" + maxDigit + "]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    public void setNumber(String number) {
        if(number.length() == 0) {
            this.number = "";
            return;
        }

        if(number.charAt(0) == '-') {   //if number is negative, delete sign from number and set isNegative field to true. After conversion sign will be add back.
            number = number.substring(1);
            this.isNegative = true;
        } else {
            this.isNegative = false;
        }

        this.number = number;
        this.number = this.number.toLowerCase().trim();
    }

    public void setFrom(int startingSystem) {
        this.from = startingSystem;
    }

    public void setTo(int targetSystem) {
        this.to = targetSystem;
    }

    public String getResult() {
        return number;
    }

}