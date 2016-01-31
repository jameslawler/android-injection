package com.jameslawler.roboguiceexample.Main;

import com.jameslawler.roboguiceexample.Services.Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by james on 1/30/2016.
 */
public class MainPresenterTests {
    private Calculator calculatorMock = mock(Calculator.class);
    private IMainView mainViewMock = mock(IMainView.class);
    private MainPresenter presenter;

    @Before
    public void setup() {
        this.presenter = new MainPresenter(calculatorMock);
        this.presenter.bindView(this.mainViewMock);
    }

    @Test
    public void whenCalculateShouldCalculateAndShowResult() {
        // Arrange
        String input1 = "10";
        String input2 = "20";
        when(this.calculatorMock.Add(10, 20)).thenReturn(30);

        // Act
        this.presenter.onCalculateClicked(input1, input2);

        // Assert
        verify(this.calculatorMock).Add(10, 20);
        verify(this.mainViewMock).showResult("30");
    }

    @Test
    public void whenCalculateWithInvalidInputShouldShouldShowErrorMessageInResult() {
        // Arrange
        String input1 = "abc";
        String input2 = "20";

        // Act
        this.presenter.onCalculateClicked(input1, input2);

        // Assert
        verify(this.mainViewMock).showResult("Bad input");
    }
}
