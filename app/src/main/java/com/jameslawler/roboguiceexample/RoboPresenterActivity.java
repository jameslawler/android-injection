package com.jameslawler.roboguiceexample;

import android.os.Bundle;

import com.google.inject.Inject;

import butterknife.ButterKnife;
import roboguice.activity.RoboActivity;

/**
 * Created by james on 1/30/2016.
 */
public class RoboPresenterActivity<T extends IPresenter> extends RoboActivity {
    @Inject
    protected T presenter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        this.presenter.bindView(this);

        if (savedInstanceState == null) {
            this.presenter.resetState();
        }
    }

    @Override
    protected void onDestroy() {
        this.presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        this.presenter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        this.presenter.onPause();
        super.onPause();
    }
}
