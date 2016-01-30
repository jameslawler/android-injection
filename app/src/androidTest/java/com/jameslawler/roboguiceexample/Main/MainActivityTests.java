package com.jameslawler.roboguiceexample.Main;

import com.jameslawler.roboguiceexample.BuildConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;

/**
 * Created by james on 1/23/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTests {
    @Before
    public void setup() {
        RoboGuice.overrideApplicationInjector(Robolectric.application, new MyTestModule());
    }

    @After
    public void teardown() {
        RoboGuice.Util.reset();
    }

    @Test
    public void createTriggersCompute() throws InterruptedException {
        Robolectric.buildActivity(MyActivity.class).create().start();
        verify(serviceMock).compute();
    }
}
