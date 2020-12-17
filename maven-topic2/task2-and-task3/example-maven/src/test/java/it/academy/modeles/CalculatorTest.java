package it.academy.modeles;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    @Test
    public void getSquare() {
        Calculator calculator = new Calculator();
        int number = 3;
        int expectedResult = 9;
        int actualResult = calculator.getSquare(number);
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void getSinus() {
        Calculator calculator = new Calculator();
        int number = 45;
        double expectedResult = 0.8509035245341184;
        double actualResult = calculator.getSinus(number);
        Assertions.assertEquals(actualResult, expectedResult);
    }
}