package com.jameslawler.roboguiceexample;

/**
 * Created by james on 1/30/2016.
 */
public interface IPresenter<T> {
    void bindView(T view);
    void onResume();
    void onPause();
    void onDestroy();
    void resetState();
}
