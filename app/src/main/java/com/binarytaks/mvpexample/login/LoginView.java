package com.binarytaks.mvpexample.login;

/**
 * Created by shijo on 22/7/17.
 */

interface LoginView {
    String getUserName();
    void showUserNameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);
}
