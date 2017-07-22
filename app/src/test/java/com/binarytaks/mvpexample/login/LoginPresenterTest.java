package com.binarytaks.mvpexample.login;

import com.binarytaks.mvpexample.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by shijo on 22/7/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorWhenUsernameIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUserNameError(R.string.username_error);
    }

    @Test
    public void shouldShowErrorWhenPasswordIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("user@gmail.com");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();
        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void shouldStartMainActivityWhenUserNameAndPasswordAreCorrect() throws Exception {
        when(view.getUserName()).thenReturn("user@gmail.com");
        when(view.getPassword()).thenReturn("password");
        when(service.login("user@gmail.com", "password")).thenReturn(true);
        presenter.onLoginClicked();
        verify(view).startMainActivity();

    }

    @Test
    public void shouldShowLoginErrorToastWhenUsernameAndPasswordAreIncorrect() throws Exception {
        when(view.getUserName()).thenReturn("user");
        when(view.getPassword()).thenReturn("pas");
        when(service.login("user", "pas")).thenReturn(false);
        presenter.onLoginClicked();
        verify(view).showLoginError(R.string.login_error);

    }
}