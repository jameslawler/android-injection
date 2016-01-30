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
    private int count;

    @Inject
    public MainPresenter(Calculator calculator) {
        this.calculator = calculator;
        this.count = 0;
    }

    @Override
    public void onResume() {
        if (this.view == null) {
            return;
        }

        this.count++;
        Integer result = this.calculator.Add(3, this.count);
        this.view.showMessage("The result is " + result.toString());
    }

    @Override
    public void onPause() {
        if (this.view == null) {
            return;
        }

        this.view.showMessage("Paused");
    }

    @Override
    public void resetState() {
        this.count = 0;
    }
}
