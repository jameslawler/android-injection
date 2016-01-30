package com.jameslawler.roboguiceexample;

/**
 * Created by james on 1/30/2016.
 */
public class Presenter<T> implements IPresenter<T> {
    protected T view;

    @Override
    public void bindView(T view) {
        this.view = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void resetState() {

    }
}
