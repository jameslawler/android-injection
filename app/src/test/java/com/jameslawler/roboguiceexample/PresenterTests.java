package com.jameslawler.roboguiceexample;

import com.jameslawler.roboguiceexample.Main.IMainView;
import com.jameslawler.roboguiceexample.Main.MainPresenter;
import com.jameslawler.roboguiceexample.Services.Calculator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by james on 1/31/2016.
 */
public class PresenterTests {
    private Presenter<IMainView> presenter;

    @Before
    public void setup() {
        this.presenter = new Presenter<>();
    }

    @Test
    public void whenBindViewToPresenterShouldStoreViewInPresenter() {
        // Arrange
        IMainView mainViewMock = mock(IMainView.class);

        // Act
        this.presenter.bindView(mainViewMock);

        // Assert
        Assert.assertEquals(mainViewMock, this.presenter.view);
    }

    @Test
    public void whenPresenterIsDestroyedShouldRemoveViewFromPresenter() {
        // Arrange
        IMainView mainViewMock = mock(IMainView.class);

        // Act
        this.presenter.bindView(mainViewMock);
        this.presenter.onDestroy();

        // Assert
        Assert.assertNull(this.presenter.view);
    }
}
