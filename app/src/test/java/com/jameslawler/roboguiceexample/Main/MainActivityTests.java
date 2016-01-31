package com.jameslawler.roboguiceexample.Main;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import com.google.inject.AbstractModule;
import com.jameslawler.roboguiceexample.BuildConfig;
import com.jameslawler.roboguiceexample.R;

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

    @Before
    public void setup() {
        RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new MainActivityMock());

        mainActivity = Robolectric.buildActivity(MainActivity.class)
                                    .create()
                                    .start()
                                    .get();
        calculate = (Button) mainActivity.findViewById(R.id.calculate);
        input1 = (EditText) mainActivity.findViewById(R.id.input1);
        input2 = (EditText) mainActivity.findViewById(R.id.input2);
    }

    @After
    public void teardown() {
        RoboGuice.Util.reset();
    }

    @Test
    public void whenPressCalculateShouldShowResult() {
        // Arrange
        input1.setText("15");
        input2.setText("22");

        // Act
        calculate.performClick();

        // Assert
        verify(this.presenterMock).onCalculateClicked("15", "22");
    }

    @Test
    public void whenPressCalculateShouldShowResult2() {
        // Arrange
        input1.setText("1");
        input2.setText("2");

        // Act
        calculate.performClick();

        // Assert
        verify(this.presenterMock).onCalculateClicked("1", "2");
    }

    public class MainActivityMock extends AbstractModule {
        @Override
        protected void configure() {
            bind(MainPresenter.class).toInstance(presenterMock);
        }
    }
}