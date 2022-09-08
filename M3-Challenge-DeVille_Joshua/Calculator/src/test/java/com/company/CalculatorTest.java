package com.company;

import org.junit.Before;
import org.junit.Test;
import sun.net.util.IPAddressUtil;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void shouldDividePositives() {

        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {

        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    @Test
    public void shouldSubtractTwoPositivesAndReturnNegative(){
        assertEquals(-1, calc.subtract(4,5));
        assertEquals(-7, calc.subtract(4,11));
        assertEquals(-9, calc.subtract(8,17));
    }
    @Test
    public void shouldSubtractTwoPositivesAndReturnPositive(){
        assertEquals(6,  calc.subtract(11, 5));
        assertEquals(10, calc.subtract(20,10));
        assertEquals(7,  calc.subtract(10,3));
    }

    @Test
    public void shouldSubtractTwoNegativesAndReturnNegative(){
        assertEquals(-2,  calc.subtract(-6,-4));
        assertEquals(-11, calc.subtract(-20,-9));
        assertEquals(-17, calc.subtract(-30,-13));
    }

    @Test
    public void shouldSubtractTwoNegativesAndReturnPositive(){
        assertEquals(8, calc.subtract(-8,-16));
        assertEquals(4, calc.subtract(-6,-10));
        assertEquals(9, calc.subtract(-12,-21));
    }

    @Test
    public void shouldSubtractPositiveIntegerAndNegativeAndReturnAddedInteger(){
        assertEquals(32, calc.subtract(12, -20));
        assertEquals(16, calc.subtract(4,-12));
        assertEquals(19, calc.subtract(5,-14));

    }


    @Test
    public void shouldAddTwoPositiveIntegers(){
        assertEquals(1,  calc.add(1,0));
        assertEquals(5,  calc.add(3,2));
        assertEquals(11, calc.add(4,7));
    }

    @Test
    public void ShouldAddTwoNegativeIntegers(){
        assertEquals(-11, calc.add(-6,-5));
        assertEquals(-14, calc.add(-7, -7));
        assertEquals(-20, calc.add(-10,-10));
    }

    @Test
    public void shouldAddOnePositiveOneNegativeAndReturnNegative(){
        assertEquals(-4, calc.add(16,-20));
        assertEquals(-3, calc.add(4,-7));
        assertEquals(-8, calc.add(4,-12));
    }
    @Test
    public void shouldAddOnePositiveOneNegativeAndReturnPositive(){
        assertEquals(12, calc.add(20,-8));
        assertEquals(5,  calc.add(10,-5));
        assertEquals(7,  calc.add(10,-3));

    }

    @Test
    public void shouldMultiplyTwoPositiveAndReturnPositive(){
        assertEquals(16, calc.multiply(4,4));
        assertEquals(20, calc.multiply(4, 5));
        assertEquals(21, calc.multiply(7,3));
    }

    @Test
    public void shouldMultiplyOnePositiveOneNegativeAndReturnNegative(){
        assertEquals(-16, calc.multiply(-4,4));
        assertEquals(-70, calc.multiply(10,-7));
        assertEquals(-9,  calc.multiply(-3,3));
    }

    @Test
    public void shouldMultiplyTwoNegativesAndReturnPositive(){
        assertEquals(49, calc.multiply(-7,-7));
        assertEquals(56, calc.multiply(-7,-8));
        assertEquals(60, calc.multiply(-10, -6));
    }


}
