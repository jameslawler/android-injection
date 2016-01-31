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
        String input1 = txtInput1.getText().toString();
        String input2 = txtInput2.getText().toString();

        this.presenter.onCalculateClicked(input1, input2);
    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}
