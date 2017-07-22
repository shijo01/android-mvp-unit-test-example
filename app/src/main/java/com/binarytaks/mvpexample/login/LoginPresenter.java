package com.binarytaks.mvpexample.login;

import com.binarytaks.mvpexample.R;

/**
 * Created by shijo on 22/7/17.
 */

class LoginPresenter {
    private LoginView mView;
    private LoginService mLoginService;

    public LoginPresenter(LoginView view, LoginService service) {

        mView = view;
        mLoginService = service;
    }

    public void onLoginClicked() {
        String username = mView.getUserName();
        String password = mView.getPassword();
        if (null == username || username.isEmpty()) {
            mView.showUserNameError(R.string.username_error);
            return;
        }
        if (null == password || password.isEmpty()) {
            mView.showPasswordError(R.string.password_error);
            return;
        }

        if (mLoginService.login(username, password)) {
            mView.startMainActivity();
            return;
        } else {
            mView.showLoginError(R.string.login_error);
        }

    }
}
