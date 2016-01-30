package com.jameslawler.roboguiceexample.Main;

import com.google.inject.Inject;
import com.jameslawler.roboguiceexample.IPresenter;
import com.jameslawler.roboguiceexample.Presenter;
import com.jameslawler.roboguiceexample.Services.Calculator;

import javax.inject.Singleton;

/**
 * Created by james on 1/30/2016.
 */

@Singleton
public class MainPresenter extends Presenter<IMainView> implements IPresenter<IMainView> {
    private Calculator calculator;

    @Inject
    public MainPresenter(Calculator calculator) {
        this.calculator = calculator;
    }

    public void calculate(String input1, String input2) {
        Integer input1AsInteger = Integer.parseInt(input1);
        Integer input2AsInteger = Integer.parseInt(input2);

        Integer result = this.calculator.Add(input1AsInteger, input2AsInteger);

        this.view.showResult(result.toString());
    }
}
