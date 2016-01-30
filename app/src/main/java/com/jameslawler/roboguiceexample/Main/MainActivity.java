package com.jameslawler.roboguiceexample.Main;

import android.os.Bundle;
import android.widget.TextView;

import com.google.inject.Inject;
import com.jameslawler.roboguiceexample.R;
import com.jameslawler.roboguiceexample.RoboPresenterActivity;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboPresenterActivity<MainPresenter> implements IMainView {
    @InjectView(R.id.textView)
    TextView textview;

    @Override
    public void showMessage(String message) {
        textview.setText(message);
    }
}
