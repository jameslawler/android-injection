package com.jameslawler.roboguiceexample.Services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by james on 1/31/2016.
 */
public class CalculatorTests {
    private Calculator calculator;

    @Before
    public void setup() {
        this.calculator = new Calculator();
    }

    @Test
    public void whenAddShouldReturnCorrectResult() {
        // Arrange
        Integer firstNumber = 9;
        Integer secondNumber = 7;
        Integer expectedResult = 16;

        // Act
        Integer result = this.calculator.Add(firstNumber, secondNumber);

        // Assert
        Assert.assertEquals(expectedResult, result);
    }
}
