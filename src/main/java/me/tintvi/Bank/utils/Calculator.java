package me.tintvi.Bank.utils;

public class Calculator {

    public static int add(int addend1, int addend2){
        int sum = addend1 + addend2;
        return sum;
    }

    public static int subtract(int minuend, int subtrahend){
        int difference = minuend - subtrahend;
        return difference;
    }

    public static int multiply(int multiplier, int multiplicand){
        int product = multiplier * multiplicand;
        return product;
    }

    public static int divide(int dividend, int divisor){
        int fraction = dividend / divisor;
        return fraction;
    }
}
