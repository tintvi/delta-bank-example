package me.tintvi.Bank.utils;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(3, Calculator.add(1, 2));
    }

    @org. junit.jupiter.api.Test
    void subtract() {
        assertEquals(5, Calculator.subtract(12, 7));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertEquals(60, Calculator.multiply(12, 5));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        assertEquals(11, Calculator.divide(110, 10));
    }
}