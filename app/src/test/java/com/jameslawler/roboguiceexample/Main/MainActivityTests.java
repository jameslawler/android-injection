package com.jameslawler.roboguiceexample.Main;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.inject.AbstractModule;
import com.jameslawler.roboguiceexample.BuildConfig;
import com.jameslawler.roboguiceexample.R;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import roboguice.RoboGuice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTests {
    private MainPresenter presenterMock = mock(MainPresenter.class);
    private MainActivity mainActivity;
    private Button calculate;
    private EditText input1;
    private EditText input2;
    private TextView result;

    @Before
    public void setup() {
        RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new MainActivityMock());

        this.mainActivity = Robolectric.buildActivity(MainActivity.class)
                                    .create()
                                    .start()
                                    .get();
        this.calculate = (Button) mainActivity.findViewById(R.id.calculate);
        this.input1 = (EditText) mainActivity.findViewById(R.id.input1);
        this.input2 = (EditText) mainActivity.findViewById(R.id.input2);
        this.result = (TextView) mainActivity.findViewById(R.id.result);
    }

    @After
    public void teardown() {
        RoboGuice.Util.reset();
    }

    @Test
    public void whenPressCalculateShouldShowResult() {
        // Arrange
        this.input1.setText("15");
        this.input2.setText("22");

        // Act
        this.calculate.performClick();

        // Assert
        verify(this.presenterMock).onCalculateClicked("15", "22");
    }

    @Test
    public void whenShowResultShouldShowResultInLabel() {
        // Arrange
        String expectedResult = "Result is 150";

        // Act
        this.mainActivity.showResult(expectedResult);

        // Assert
        Assert.assertEquals(expectedResult, this.result.getText().toString());
    }

    public class MainActivityMock extends AbstractModule {
        @Override
        protected void configure() {
            bind(MainPresenter.class).toInstance(presenterMock);
        }
    }
}