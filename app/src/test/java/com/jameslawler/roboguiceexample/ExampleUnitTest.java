package com.jameslawler.roboguiceexample;

import android.os.Build;

import com.google.inject.AbstractModule;
import com.jameslawler.roboguiceexample.Main.MainActivity;
import com.jameslawler.roboguiceexample.Services.Calculator;

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

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ExampleUnitTest {
    private Calculator serviceMock = mock(Calculator.class);

    @Before
    public void setup() {
        // Override the default RoboGuice module
        RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new MyTestModule());
    }

    @After
    public void teardown() {
        // Don't forget to tear down our custom injector to avoid polluting other test classes
        RoboGuice.Util.reset();
    }

    @Test
    public void createTriggersCompute() {
        Robolectric.buildActivity(MainActivity.class).create().start();
        verify(serviceMock).Add(2, 3);
    }


    public class MyTestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Calculator.class).toInstance(serviceMock);
        }
    }
}