package com.jameslawler.roboguiceexample.Main;

import android.widget.EditText;
import android.widget.TextView;

import com.jameslawler.roboguiceexample.R;
import com.jameslawler.roboguiceexample.RoboPresenterActivity;

import butterknife.OnClick;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboPresenterActivity<MainPresenter> implements IMainView {
    @InjectView(R.id.input1)
    EditText txtInput1;

    @InjectView(R.id.input2)
    EditText txtInput2;

    @InjectView(R.id.result)
    TextView txtResult;

    @OnClick(R.id.calculate)
    public void onCalculateClick() {
        this.presenter.calculate(txtInput1.getText().toString(), txtInput2.getText().toString());
    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}
