package com.jameslawler.roboguiceexample;

import com.jameslawler.roboguiceexample.Main.IMainView;

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
